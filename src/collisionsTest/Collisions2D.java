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
		TestBall ball1 = new TestBall(0, 15, Color.RED);
		TestBall ball2 = new TestBall(900, 720, Color.BLUE);
		TestBall ball3 = new TestBall(33, 15, Color.GREEN);
		TestBall ball4 = new TestBall(500, 700, Color.MAGENTA);
		
		balls = new TestBall[4];
		balls[0] = ball1;
		balls[1] = ball2;
		balls[2] = ball3;
		balls[3] = ball4;
		balls_size = 4;
		
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
	
	private static int finalVX(TestBall ball1, TestBall ball2) {
		return (int) ((ball1.getR() - ball2.getR())*ball1.getVx() + ball2.getD()*ball2.getVx())/(ball1.getR()+ball2.getR()); 
	}
	
	
	public static void moveBalls() {
		
		for(TestBall b: balls) {	
			
			b.x += b.vx;
			if(b.x>WIDTH-b.getR() || b.x <=0) {
				b.vx = -b.vx;
				b.x += (int) b.vx;
			}
			
			b.y += b.vy;
			if(b.y>HEIGHT-b.getR() || b.y <=0) {
				b.vy = -b.vy;
				b.y += (int) b.vy;
			}
			
		}
		collisions();
	}
	
	public static void collisions() {
		for(int i=0; i<balls_size-1; i++) {
			for(int j=i+1; j<balls_size; j++) {
				if(TestBall.ballsCollide(balls[i], balls[j])) {
					balls[i].vx = finalVX(balls[i], balls[j]);
					balls[j].vx = -finalVX(balls[j], balls[i]);
				}
			}
		}
	}
	
	protected static void computeNewVelocity(TestBall b1, TestBall b2) {
		
		double angle = Math.atan2((double) b1.getX()-b2.getX(), (double) b1.getY()-b2.getY());
		
		double sin = Math.sin(angle), cos = Math.cos(angle);
		
		int v1[] = {(int) ((double) b1.getVx() * cos + (double) b1.getVy() * sin), (int) ((double) -b1.getVx() * sin + (double) b1.getVy() * cos)};
		
		int v2[] = {(int) ((double) b2.getVx() * cos + (double) b2.getVy() * sin), (int) ((double) -b2.getVx() * sin + (double) b2.getVy() * cos)};
		
		b1.vx = v1[0];
		b1.vy = v1[1];
		
		b2.vx = v2[0];
		b2.vy = v2[1];
		
		v1[0] = finalVX(b1, b2);
		
		v2[0] = finalVX(b2, b1);
		
		b1.vx = (int) ((double) v1[0] * cos - (double) v1[1] * sin);
		b1.vy = (int) ((double) v2[0] * sin + (double) v2[1] * cos);
		
		
	}
}
