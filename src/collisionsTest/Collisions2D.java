package collisionsTest;

import java.awt.Color;

import javax.swing.JFrame;

public class Collisions2D {
	public static final int HEIGHT = 800;
	public static final int WIDTH = 1000;
	
	public static TestBall[] balls;
	public static int balls_size;
	
	public static void collisions2D() {
		TestBall ball1 = new TestBall(0, HEIGHT/2, Color.RED);
		TestBall ball2 = new TestBall(900, HEIGHT/2, Color.BLUE);
		
		balls = new TestBall[2];
		balls[0] = ball1;
		balls[1] = ball2;
		balls_size = 2;
		
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
	
	public static int finalVX(TestBall ball1, TestBall ball2) {
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
	
	protected static int findAngle(TestBall b1, TestBall b2) {
		int angle=3;
		
		return angle;
	}
	
}
