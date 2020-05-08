package collisionsTest;

import java.awt.Color;

import javax.swing.JFrame;

import colorpool.core.Ball;

public class Collisions2D {
	public static final int HEIGHT = 800;
	public static final int WIDTH = 1000;
	
	public static TestBall[] balls;
	public static int balls_size;
	
	public static void collisions2D() {
		
		balls = new TestBall[8];
		balls[0] = new TestBall(0.0, 15.0, Color.RED);
		balls[1] = new TestBall(900.0, 720.0, Color.BLUE);
		balls[2] = new TestBall(33.0, 15.0, Color.GREEN);
		balls[3] = new TestBall(500.0, 700.0, Color.MAGENTA);
		balls[4] = new TestBall(100.0, 15.0, Color.WHITE);
		balls[5] = new TestBall(570.0, 640.0, Color.BLACK);
		balls[6] = new TestBall(10.0, 300.0, Color.CYAN);
		balls[7] = new TestBall(200.0, 305.0, Color.ORANGE);
		balls_size = 8;
		
		JFrame frame = new JFrame("Collisions2D");
		frame.setSize(WIDTH, HEIGHT);
		
		BallPanel panel = new BallPanel();
		panel.setBalls(balls, balls_size);
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			moveBalls();
			panel.setBalls(balls, balls_size);
			panel.repaint();
		}
		
		
	}
	
	private static double finalVX(TestBall ball1, TestBall ball2) {
		return ((ball1.getR() - ball2.getR())*ball1.getVx() + ball2.getD()*ball2.getVx())/(ball1.getR()+ball2.getR()); 
	}
	
	
	public static void moveBalls() {
		
		for(TestBall b: balls) {	
			
			b.x += b.vx;
			if(b.x>WIDTH-b.getD() || b.x <=0) {
				b.vx = -b.vx;
				b.x +=  b.vx;
			}
			
			b.y += b.vy;
			if(b.y>HEIGHT-b.getD() || b.y <=0) {
				b.vy = -b.vy;
				b.y +=  b.vy;
			}
			
		}
		collisions();
	}
	
	public static void collisions() {
		for(int i=0; i<balls_size-1; i++) {
			for(int j=i+1; j<balls_size; j++) {
				if(TestBall.ballsCollide(balls[i], balls[j])) {
					//balls[i].vx = finalVX(balls[i], balls[j]);
					//balls[j].vx = -finalVX(balls[j], balls[i]);
					computeNewVelocity(balls[i], balls[j]);
				}
			}
		}
	}
	
	protected static void computeNewVelocity(TestBall b1, TestBall b2) {
		
		double angle = Math.atan2(  b1.getY()-b2.getY(),   b1.getX()-b2.getX());
		
		double sin = Math.sin(angle), cos = Math.cos(angle);
		
		double v1[] = { (  b1.getVx() * cos +   b1.getVy() * sin), (  -b1.getVx() * sin +   b1.getVy() * cos)};
		
		double v2[] = { (  b2.getVx() * cos +   b2.getVy() * sin),  (  -b2.getVx() * sin +   b2.getVy() * cos)};
		
		b1.vx = v1[0];
		b1.vy = v1[1];
		
		b2.vx = v2[0];
		b2.vy = v2[1];
		
		v1[0] = finalVX(b1, b2);
		
		v2[0] = finalVX(b2, b1);
		
		b1.vx = ( v1[0] * cos -   v1[1] * sin);
		b1.vy = ( v1[0] * sin +   v1[1] * cos);
		
		b2.vx = ( v2[0] * cos -   v2[1] * sin);
		b2.vy = ( v2[0] * sin +   v2[1] * cos);
		
	}
}
