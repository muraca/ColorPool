package colorpool.core;

import colorpool.config.Settings;

public class Pot {
	//Coordinates of top/left pixel
	private double x;
	private double y;
	
	private int d;
	
	public Pot(double x, double y) {
		this.x = x;
		this.y = y;
		this.d = Settings.POTDIMENSION;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getDimension() {
		return d;
	}
	
    public double getR() {
        return ((double) d) / 2.0;
    }
}
