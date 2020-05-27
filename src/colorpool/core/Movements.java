package colorpool.core;

import colorpool.config.Settings;

public class Movements {
	
	//Chiamato al click del mouse, serve a lanciare la pallina bianca se il gioco è fermo
	private static final double speed = 10.0;
    private static double friction=0.01;
	
	public static void shotWhiteBall(int x, int y) {
		
		double dx = (double) Math.abs(Game.getGame().getWhiteBall().x-x);
		double dy = (double) Math.abs(Game.getGame().getWhiteBall().y-y);
			
		double angle = Math.atan2(dy, dx);
		double sin = Math.sin(angle), cos = Math.cos(angle);
			
		double speedx = speed * cos;
		double speedy =  speed * sin;
		
		if(x>Game.getGame().getWhiteBall().x)
			Game.getGame().getWhiteBall().vx = speedx;
		else
			Game.getGame().getWhiteBall().vx = -speedx;
			
		if(y>Game.getGame().getWhiteBall().y)
			Game.getGame().getWhiteBall().vy = speedy;
		else
			Game.getGame().getWhiteBall().vy = -speedy;
	}
	
	//Muove e rallenta tutte le palle, richiama poi i metodi di controllo buche e collisioni
	public static void moveBalls() {
		//muove e poi rallenta la palla bianca
		
		moveBall(Game.getGame().getWhiteBall());
		slowDown(Game.getGame().getWhiteBall());
		
		//muove e poi rallenta ogni palla colorata
		for(Ball b: Game.getGame().getBalls()) {
			moveBall(b);
			slowDown(b);
		}
		
		potting();
		
		collisions();
	}
	
	//Muove la singola pallina in direzione e verso dipendenti dalla velocità
	//Inoltre controlla le collisioni con il muro
	private static void moveBall(Ball b) {
		b.x += b.vx;
		
		if(b.isOutX()) {
			b.vx = -b.vx;
			if(b.vx>=0)
				b.x = Settings.POOLMINX;
			else
				b.x = Settings.POOLMAXX-b.getD();
		}
		
		b.y += b.vy;
		
		if(b.isOutY()) {
			b.vy = - b.vy;
			if(b.vy>=0)
				b.y = Settings.POOLMINY;
			else
				b.y = Settings.POOLMAXY-b.getD();
		}
		
	}
	
	//Rallenta la pallina di una costante friction
	private static void slowDown(Ball b) {
			
		if(b.vx>=friction)
			b.vx -= friction;
		else if(b.vx<=-friction)
			b.vx += friction;
		else
			b.vx = 0.0;
				
		if(b.vy>=friction)
			b.vy -= friction;
		else if(b.vy<=-friction)
			b.vy += friction;
		else
			b.vy = 0.0;
	}
	
	//Controlla tutte le palline per vedere se una è andata in buca
	private static void potting() {
		
		if(potted(Game.getGame().getWhiteBall())) {
			Game.getGame().pot(Game.getGame().getWhiteBall());
		}
		
		for(Ball b: Game.getGame().getBalls()) {
			if(potted(b)) {
				Game.getGame().pot(b);
			}
		}
	}
	
	//Controlla se la singola pallina è andata in buca
	private static boolean potted(Ball b) {
		int x = (int) b.x, y = (int) b.y;
		//controllo con le buche centrali
		if(((x>=668 && x<=713)||x<=100||x>=1290) && b.isOutY()) {
			return true;
		}
		//controllo con le buche agli angoli
		else if(b.isOutX() && (y>=705 || y<=95)) {
			return true;
		}
			
		return false;
	}
	
	//Gestisce le collisioni tra tutte le palline
	private static void collisions() {
		//Prima la pallina bianca con ogni singola colorata
		for(Ball b: Game.getGame().getBalls()) {
			if(ballsCollide(Game.getGame().getWhiteBall(), b)) {
				computeNewVelocity(Game.getGame().getWhiteBall(), b);
			}
		}
		//Poi le colorate tra di loro, evitando di fare ripetizioni
		for(int i=0; i<Game.getGame().getBalls().size()-1; i++) {
			for(int j=i+1; j<Game.getGame().getBalls().size(); j++) {
				if(ballsCollide(Game.getGame().getBalls().get(i), Game.getGame().getBalls().get(j))) {
					computeNewVelocity(Game.getGame().getBalls().get(i), Game.getGame().getBalls().get(j));
				}
			}
		}
	}
	
	//Risponde alla domanda "b1 e b2 collidono?"
	static Boolean ballsCollide(Ball b1, Ball b2) {
		double x1 = b1.x + b1.getR();
		double x2 = b2.x + b2.getR();
		
		double y1 = b1.y + b1.getR();
		double y2 = b2.y + b2.getR();
		
		double distanceSquared = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
		
		return distanceSquared <= (b1.getR() + b2.getR()) * (b1.getR() + b2.getR());
	}
	
	//Calcolo della velocità finale in un urto in una dimensione
	private static double finalVX(Ball ball1, Ball ball2) {
		return ((ball1.getR() - ball2.getR())*ball1.getVx() + ball2.getD()*ball2.getVx())/(ball1.getR()+ball2.getR());
	}
	
	private static void computeNewVelocity(Ball b1, Ball b2) {
		//Bugfixing per scambio palline
		if(!((b1.vx>=0&&b2.vx<=0||b1.vx<=0&&b2.vx>=0)^(b1.vy>=0&&b2.vy<=0||b1.vy<=0&&b2.vy>=0))) {
			//Calcolo l'angolo tra l'asse x e l'asse dell'impatto
			double angle = Math.atan2(b1.getY()-b2.getY(), b1.getX()-b2.getX());
			//Seno e coseno dell'angolo sopra citato
			double sin = Math.sin(angle), cos = Math.cos(angle);
			//Proiezione delle velocità sull'asse dell'urto tramite moltiplicazione con matrice
			double v1[] = {(b1.getVx() * cos + b1.getVy() * sin), (-b1.getVx() * sin + b1.getVy() * cos)};
		
			double v2[] = {(b2.getVx() * cos + b2.getVy() * sin), (-b2.getVx() * sin + b2.getVy() * cos)};
			//Assegnamento delle nuove velocità relative all'asse dell'urto
			b1.vx = v1[0];
			b1.vy = v1[1];
		
			b2.vx = v2[0];
			b2.vy = v2[1];
			//Calcolo delle nuove velocità finali
			v1[0] = finalVX(b1, b2);
			v2[0] = finalVX(b2, b1);
			//Proiezione delle velocità di nuovo sugli assi principali
			b1.vx = (v1[0] * cos - v1[1] * sin);
			b1.vy = (v1[0] * sin + v1[1] * cos);
		
			b2.vx = (v2[0] * cos - v2[1] * sin);
			b2.vy = (v2[0] * sin + v2[1] * cos);
		}
		
	}
	
	public static void stopBalls() {
		//Fermo la pallina bianca
		Game.getGame().getWhiteBall().vx = 0;
		Game.getGame().getWhiteBall().vy = 0;
		//Fermo tutte le altre palline
		for(Ball b: Game.getGame().getBalls()) {
			b.vx = 0;
			b.vy = 0;
		}
	}
	
	
}
