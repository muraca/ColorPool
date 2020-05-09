package colorpool.core;

import java.awt.Color;

public class Ball {
    //Coordinates of top/left pixel
    double x;
    double y;
    
    //Dimension of the ball
    protected int d;
    
    //Speed on both axises
    double vx;
    double vy;
    
    //Color of the ball
    Color color;
    
    public Ball(int _x, int _y, Color _c) {
        this.x = _x;
        this.y = _y;
        
        this.color = _c;
        this.d = 30;
        
        this.vx = 0.0;
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
    
    public double getX() {
        return x;
    }
    
    public double getY() {
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
