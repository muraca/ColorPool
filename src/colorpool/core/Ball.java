package colorpool.core;

import java.awt.Color;

import colorpool.config.Settings;

public class Ball {
    //Coordinate del pixel in alto a sinistra
    double x;
    double y;
    
    //Dimensione della palla
    protected int d;
    
    //Componenti del vettore velocità
    double vx;
    double vy;
    
    //Colore della palla
    Color color;
    
    public Ball(int _x, int _y, Color _c) {
        this.x = _x;
        this.y = _y;
        
        this.color = _c;
        this.d = Settings.BALLDIMENSION;
        
        this.vx = 0.0;
        this.vy = 0.0;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
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
    
    public Color getColor() {
        return color;
    }
    
    public int getD() {
        return d;
    }
    
    public int getR() {
        return d/2;
    }
	
    public boolean isOutX() {
    	if(x >= Settings.POOLMAXX-d|| x <= Settings.POOLMINX)
    		return true;
    	return false;
    }
    
    public boolean isOutY() {
    	if(y >= Settings.POOLMAXY-d || y <= Settings.POOLMINY)
    		return true;
    	return false;
    }
    
    public boolean equalsTo(Ball b) {
		if(this.color==b.color)
			return true;
		return false;

	}
    
}
