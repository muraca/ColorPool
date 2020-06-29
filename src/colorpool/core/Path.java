package colorpool.core;

//indicatore della traiettoria della pallina bianca
public class Path {
	double x;
	double y;
	static final int dimension = 10;
	
	public Path(double x,double y) {
		this.x = x;
		this.y = y;
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
	
}

