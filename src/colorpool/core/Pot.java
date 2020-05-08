package colorpool.core;

public class Pot {
	//Coordinates of top/left pixel
	private int x;
	private int y;
	
	final static int d = 50;
	
	public Pot(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static int getDimension() {
		return d;
	}
	
	
}
