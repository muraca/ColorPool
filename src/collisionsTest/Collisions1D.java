package collisionsTest;


import java.awt.Color;

import javax.swing.JFrame;

public class Collisions1D {
	public static final int HEIGHT = 800;
	public static final int WIDTH = 1000;
	
	public static TestBall[] balls;
	public static int balls_size;
	
	public static void main(String[] args) {
		TestBall ball1 = new TestBall(0, HEIGHT/2, Color.RED);
		TestBall ball2 = new TestBall(900, HEIGHT/2, Color.BLUE);
		
		balls = new TestBall[2];
		balls[0] = ball1;
		balls[1] = ball2;
		balls_size = 2;
		
		JFrame frame = new JFrame();
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
	
	public static double finalVX1(TestBall ball1, TestBall ball2) {
		return ((ball1.getR() - ball2.getR())*ball1.getVx() + ball2.getD()*ball2.getVx())/(ball1.getR()+ball2.getR()); 
	}
	
	public static double finalVX2(TestBall ball1, TestBall ball2) {
		return ((ball2.getR() - ball1.getR())*ball2.getVx() + ball1.getD()*ball1.getVx())/(ball1.getR()+ball2.getR()); 
	}
	
	public static void moveBalls() {
		
		for(TestBall b: balls) {	
			
			b.x += (int) b.vx;
			if(b.x>WIDTH-b.getR() || b.x <=0) {
				b.vx = -b.vx;
				b.x += (int) b.vx;
			}
			
			b.y += (int) b.vy;
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
					balls[i].vx = finalVX1(balls[i], balls[j]);
					balls[j].vx = -finalVX2(balls[i], balls[j]);
				}
			}
		}
	}




	
}

