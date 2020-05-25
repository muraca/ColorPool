package colorpool.core;

import java.awt.Color;

public class Path 
{
	double x;
	double y;
	static final int dimension=10;
	static final Color c=Color.WHITE;
	
	public Path(double x,double y) 
	{
		this.x=x;
		this.y=y;
	}

	public double getX() {
		return x;
	}
		
	public double getY() {
		return y;
	}
	
	public int getDimension() {
		return dimension;
	}
	
	public Color getColor() {
		return c;
	}
}

