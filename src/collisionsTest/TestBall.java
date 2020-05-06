package collisionsTest;

import java.awt.Color;
import java.util.Random;

public class TestBall {
	//Coordinates of top/left pixel
		int x;
		int y;
		
		//Dimension of the ball
		protected int d;
		
		//Speed on both axises
		double vx;
		double vy;
		
		//Color of the ball
		Color color;
		
		public TestBall(int _x, int _y, Color _c) {
			this.x = _x;
			this.y = _y;
			
			this.color = _c;
			this.d = 30;
			
			Random r = new Random();
			this.vx = (double) r.nextInt(7) + 3;
			this.vy = 0.0;
		}

		public double getVx() {
			return vx;
		}

		public void setVx(double vx) {
			this.vx = vx;
		}

		public double getVy() {
			return vy;
		}

		public void setVy(double vy) {
			this.vy = vy;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public Color getColor() {
			return color;
		}
		
		public int getD() {
			return d;
		}
		
		public int getR() {
			return d/2;
		}
		
        // do these two balls collide?
		public static Boolean ballsCollide(TestBall b1, TestBall b2) {
			int x1 = b1.x + b1.getR();
			int x2 = b2.x + b2.getR();
			
			int y1 = b1.y + b1.getR();
			int y2 = b2.y + b2.getR();
			
			int distanceSquared = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
			
			return distanceSquared <= (b1.getR() + b2.getR()) * (b1.getR() + b2.getR());
		}
}
