package colorpool.core;

import colorpool.config.Settings;

public class Movements {
	
	//Chiamato al click del mouse, serve a lanciare la pallina bianca se il gioco è fermo
	public static void shotWhiteBall(Game g, int x, int y) {
		if(g.canShot()) {
			g.whiteball.vx = x;
			g.whiteball.vy = y;
		}
	}
	
	//Gestisce il movimento di tutte le palle, richiama poi i metodi di controllo buche e collisioni
	public static void moveBalls(Game g) {
		
		for(Ball b: g.balls) {	//muovo tutte le palle colorate
			moveBall(b);
		}
		
		moveBall(g.whiteball);
		
		potting(g);
		
		collisions(g);
	}
	
	//Muove la singola pallina in direzione e verso dipendenti dalla velocità
	//Inoltre controlla le collisioni con il muro
	private static void moveBall(Ball b) {
		b.x += b.vx;	
		if(b.x>Settings.WIDTH-b.getD() || b.x <=0) {
			b.vx = -b.vx;
			b.x += b.vx;
		}
		
		b.y += b.vy;
		if(b.y>Settings.HEIGHT-b.getD() || b.y <=0) {
			b.vy = -b.vy;
			b.y += b.vy;
		}
	}
	
	//Controlla se le palline sono andate in buca
	private static void potting(Game g) { }
	
	//Gestisce le collisioni tra tutte le palline
	private static void collisions(Game g) {
		//Prima la pallina bianca con ogni singola colorate
		for(Ball b: g.balls) {
			if(ballsCollide(g.whiteball, b)) {
				g.whiteball.vx = finalVX(g.whiteball, b);
				b.vx = -finalVX(b, g.whiteball);
			}
		}
		//Poi le colorate tra di loro, evitando di fare ripetizioni
		for(int i=0; i<g.balls.size()-1; i++) {
			for(int j=i+1; j<g.balls.size(); j++) {
				if(ballsCollide(g.balls.get(i), g.balls.get(j))) {
					g.balls.get(i).vx = finalVX(g.balls.get(i), g.balls.get(j));
					g.balls.get(j).vx = -finalVX(g.balls.get(j), g.balls.get(i));
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
	
}
