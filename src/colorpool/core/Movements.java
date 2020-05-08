package colorpool.core;

import colorpool.config.Settings;

public class Movements {
	
	//Chiamato al click del mouse, serve a lanciare la pallina bianca se il gioco è fermo
	private static final double speed = 10.0;
	
	public static void shotWhiteBall(int x, int y) {
		if(Game.getGame().canShot()) {
			double dx = (double) Math.abs(Game.getGame().whiteball.x-x);
			double dy = (double) Math.abs(Game.getGame().whiteball.y-y);
			int speedx = (int) Math.round(speed * dx / (dx+dy));
			int speedy = (int) Math.round(speed * dy / (dx+dy));
			
			if(x>Game.getGame().whiteball.x)
				Game.getGame().whiteball.vx = speedx;
			//else if(x==Game.getGame().whiteball.x)
			//	Game.getGame().whiteball.vx = 0;
			else
				Game.getGame().whiteball.vx = -speedx;
			
			if(y>Game.getGame().whiteball.y)
				Game.getGame().whiteball.vy = speedy;
			//else if(y==Game.getGame().whiteball.y)
			//	Game.getGame().whiteball.vy = 0;
			else
				Game.getGame().whiteball.vy = -speedy;
		}
	}
	
	//Gestisce il movimento di tutte le palle, richiama poi i metodi di controllo buche e collisioni
	public static void moveBalls() {
		
		for(Ball b: Game.getGame().balls) {	//muovo tutte le palle colorate
			moveBall(b);
		}
		
		moveBall(Game.getGame().whiteball);
		
		potting();
		
		collisions();
	}
	
	//Muove la singola pallina in direzione e verso dipendenti dalla velocità
	//Inoltre controlla le collisioni con il muro
	private static void moveBall(Ball b) {
		b.x += b.vx;	
		if(b.x>=Settings.WIDTH-b.getD() || b.x <=0) {
			b.vx = -b.vx;
			b.x += b.vx;
		}
		
		b.y += b.vy;
		if(b.y>=Settings.HEIGHT-b.getD() || b.y <=0) {
			b.vy = -b.vy;
			b.y += b.vy;
		}
	}
	
	//Controlla se le palline sono andate in buca
	private static void potting() {
		//TODO
	}
	
	//Gestisce le collisioni tra tutte le palline
	private static void collisions() {
		//Prima la pallina bianca con ogni singola colorata
		for(Ball b: Game.getGame().balls) {
			if(ballsCollide(Game.getGame().whiteball, b)) {
				computeNewVelocity(Game.getGame().whiteball, b);
			}
		}
		//Poi le colorate tra di loro, evitando di fare ripetizioni
		for(int i=0; i<Game.getGame().balls.size()-1; i++) {
			for(int j=i+1; j<Game.getGame().balls.size(); j++) {
				if(ballsCollide(Game.getGame().balls.get(i), Game.getGame().balls.get(j))) {
					computeNewVelocity(Game.getGame().balls.get(i), Game.getGame().balls.get(j));
				}
			}
		}
	}
	
	//Risponde alla domanda "b1 e b2 collidono?"
	static Boolean ballsCollide(Ball b1, Ball b2) {
		int x1 = b1.x + b1.getR();
		int x2 = b2.x + b2.getR();
		
		int y1 = b1.y + b1.getR();
		int y2 = b2.y + b2.getR();
		
		int distanceSquared = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
		
		return distanceSquared < (b1.getR() + b2.getR()) * (b1.getR() + b2.getR());
	}
	
	//Calcolo della velocità finale in un urto
	private static int finalVX(Ball ball1, Ball ball2) {
		return (int) ((ball1.getR() - ball2.getR())*ball1.getVx() + ball2.getD()*ball2.getVx())/(ball1.getR()+ball2.getR()); 
	}
	
	private static void computeNewVelocity(Ball b1, Ball b2) {
		
		double angle = Math.atan2(  b1.getY()-b2.getY(),   b1.getX()-b2.getX());
		
		double sin = Math.sin(angle), cos = Math.cos(angle);
		
		double v1[] = { (  b1.getVx() * cos +   b1.getVy() * sin), (  -b1.getVx() * sin +   b1.getVy() * cos)};
		
		double v2[] = { (  b2.getVx() * cos +   b2.getVy() * sin),  (  -b2.getVx() * sin +   b2.getVy() * cos)};
		
		b1.vx = (int) v1[0];
		b1.vy = (int) v1[1];
		
		b2.vx = (int) v2[0];
		b2.vy = (int) v2[1];
		
		v1[0] = finalVX(b1, b2);
		
		v2[0] = finalVX(b2, b1);
		
		b1.vx = (int) ( v1[0] * cos -   v1[1] * sin);
		b1.vy = (int) ( v1[0] * sin +   v1[1] * cos);
		
		b2.vx = (int) ( v2[0] * cos -   v2[1] * sin);
		b2.vy = (int) ( v2[0] * sin +   v2[1] * cos);
		
	}
	
}
