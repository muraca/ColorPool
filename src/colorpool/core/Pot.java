package colorpool.core;

public class Pot {
	//Coordinates of top/left pixel
	private double x;
	private double y;
	
	final static int d = 50;
	
	public Pot(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public static int getDimension() {
		return d;
	}
	
    public static double getR() {
        return ((double) d) / 2.0;
    }
}
