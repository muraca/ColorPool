package collisionsTest;

import java.awt.Color;
import java.util.Random;

public class TestBall {
	//Coordinates of top/left pixel
		double x;
		double y;
		
		//Dimension of the ball, also used as mass
		protected double d;
		
		//Speed on both axises
		double vx;
		double vy;
		
		//Color of the ball
		Color color;
		
		public TestBall(double _x, double _y, Color _c) {
			this.x = _x;
			this.y = _y;
			
			this.color = _c;
			this.d = 30;
			
			Random r = new Random();
			this.vx = r.nextInt(7) + 3;
			this.vy = r.nextInt(9) + 1;
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

		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}

		public Color getColor() {
			return color;
		}
		
		public double getD() {
			return d;
		}
		
		public double getR() {
			return d/2;
		}
		
        // do these two balls collide?
		public static Boolean ballsCollide(TestBall b1, TestBall b2) {
			double x1 = b1.x + b1.getR();
			double x2 = b2.x + b2.getR();
			
			double y1 = b1.y + b1.getR();
			double y2 = b2.y + b2.getR();
			
			double distanceSquared = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
			
			return distanceSquared <= (b1.getR() + b2.getR()) * (b1.getR() + b2.getR());
		}
}
