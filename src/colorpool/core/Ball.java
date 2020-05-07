package colorpool.core;

import java.awt.Color;

public class Ball {
	//Coordinates of top/left pixel
	int x;
	int y;
	
	//Dimension of the ball
	protected int d;
	
	//Speed on both axises
	int vx;
	int vy;
	
	//Color of the ball
	Color color;
	
	public Ball(int _x, int _y, Color _c) {
		this.x = _x;
		this.y = _y;
		
		this.color = _c;
		this.d = 30;
		
		this.vx = 0;
		this.vy = 0;
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
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
	
}
