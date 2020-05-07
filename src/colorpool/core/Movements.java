package colorpool.core;

import colorpool.config.Settings;

public class Movements {
	
	public static void moveWhiteBall(Game g, int x, int y) {
		if(g.canShot()) {
			g.whiteball.vx = x;
			g.whiteball.vy = y;
		}
	}
	
	private static int finalVX(Ball ball1, Ball ball2) {
		return (int) ((ball1.getR() - ball2.getR())*ball1.getVx() + ball2.getD()*ball2.getVx())/(ball1.getR()+ball2.getR()); 
	}
	
	private static Boolean ballsCollide(Ball b1, Ball b2) {
		int x1 = b1.x + b1.getR();
		int x2 = b2.x + b2.getR();
		
		int y1 = b1.y + b1.getR();
		int y2 = b2.y + b2.getR();
		
		int distanceSquared = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
		
		return distanceSquared < (b1.getR() + b2.getR()) * (b1.getR() + b2.getR());
	}
	
	public static void moveBalls(Game g) {
		
		for(Ball b: g.balls) {	//controllo tutte le palle
			moveBall(b);
		}
		
		moveBall(g.whiteball);
		
		collisions(g);
	}
	
	private static void moveBall(Ball b) {
		b.x += b.vx;	
		if(b.x>Settings.WIDTH-b.getR() || b.x <=0) {
			b.vx = -b.vx;
			b.x += b.vx;
		}
		
		b.y += b.vy;
		if(b.y>Settings.HEIGHT-b.getR() || b.y <=0) {
			b.vy = -b.vy;
			b.y += b.vy;
		}
	}
	
	private static void collisions(Game g) {
		for(Ball b: g.balls) {
			ballsCollide(g.whiteball, b);
		}
		for(int i=0; i<g.balls.size()-1; i++) {
			for(int j=i+1; j<g.balls.size(); j++) {
				if(ballsCollide(g.balls.get(i), g.balls.get(j))) {
					g.balls.get(i).vx = finalVX(g.balls.get(i), g.balls.get(j));
					g.balls.get(j).vx = -finalVX(g.balls.get(j), g.balls.get(i));
				}
			}
		}
	}
	
}
