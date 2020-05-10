package colorpool.core;

import java.awt.Color;

import colorpool.config.Settings;

public class Ball {
    //Coordinate del pixel in alto a sinistra
    double x;
    double y;
    
    //Dimensione della palla
    protected int d;
    
    //Modulo del vettore velocità
    double vx;
    double vy;
    
    //Verso del vettore velocità (true=positiva, false=negativa)
    boolean dirx;
    boolean diry;
    
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
    
    public boolean getDirx() {
		return dirx;
	}

	public void setDirx(boolean dirx) {
		this.dirx = dirx;
	}

	public boolean getDiry() {
		return diry;
	}

	public void setDiry(boolean diry) {
		this.diry = diry;
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
    
    public void changeDirectionX() {
    	if(dirx)
    		dirx = false;
    	else
    		dirx = true;
    }
    
    public void changeDirectionY() {
    	if(diry)
    		diry = false;
    	else
    		diry = true;
    }
    
    //converte da "bool per verso, double per direzione" a "double per direzione e verso"
    public void convertBoolVec() {
    	if(!dirx)
    		vx = -vx;
    	if(!diry)
    		vy = -vy;
    }
    
    //converte da "double per direzione e verso" a "bool per verso, double per direzione"
    public void convertVecBool() {
    	if(vx<0) {
    		vx = -vx;
    		dirx = false;
    	}
    	else
    		dirx = true;
    	
    	if(vy<0) {
    		vy = -vy;
    		diry = false;
    	}
    	else
    		diry = true;
    }
    
}
