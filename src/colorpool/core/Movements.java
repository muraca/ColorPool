package colorpool.core;

import javax.swing.JOptionPane;

public class Movements {
	
	//Chiamato al click del mouse, serve a lanciare la pallina bianca se il gioco è fermo
	private static final double speed = 10.0;
    private static double friction=0.01;
	
	public static void shotWhiteBall(int x, int y) {
		
		double dx = (double) Math.abs(Game.getGame().whiteball.x-x);
		double dy = (double) Math.abs(Game.getGame().whiteball.y-y);
			
		double angle = Math.atan2(dy, dx);
		double sin = Math.sin(angle), cos = Math.cos(angle);
			
		double speedx = Math.abs(speed * cos);
		double speedy =  Math.abs(speed * sin);
			
		Game.getGame().whiteball.vx = speedx;
		Game.getGame().whiteball.vy = speedy;
		
		if(x>Game.getGame().whiteball.x)
			Game.getGame().whiteball.dirx = true;
		else
			Game.getGame().whiteball.dirx = false;
			
		if(y>Game.getGame().whiteball.y)
			Game.getGame().whiteball.diry = true;
		else
			Game.getGame().whiteball.diry = false;
	}
	
	//Gestisce il movimento di tutte le palle, richiama poi i metodi di controllo buche e collisioni
	public static void moveBalls() {
		//muovo tutte le palle colorate
		for(Ball b: Game.getGame().balls) {
			moveBall(b);
		}
		
		moveBall(Game.getGame().whiteball);
		
		potting();
		
		collisions();
	}
	
	//Muove la singola pallina in direzione e verso dipendenti dalla velocità
	//Inoltre controlla le collisioni con il muro
	private static void moveBall(Ball b) {
		
		if(b.dirx)
			b.x += b.vx;
		else
			b.x -= b.vx;	
		
		if(b.isOutX()) {
			b.changeDirectionX();
			if(b.dirx)
				b.x += b.vx;
			else
				b.x -= b.vx;
		}
		
		
		if(b.diry)
			b.y += b.vy;
		else
			b.y -= b.vy;	
		
		if(b.isOutY()) {
			b.changeDirectionY();
			if(b.diry)
				b.y += b.vy;
			else
				b.y -= b.vy;
		}
		
	}
	
	private void friction(Ball b) {
		if(b.vx>=friction)
			b.vx -= friction;
		else if(b.vx>0)
			b.vx = 0;
		
		if(b.vy>=friction)
			b.vy -=friction;
		else if(b.vy>0)
			b.vy = 0;
	}
	
	//Controlla se le palline sono andate in buca
	private static void potting() {
        //Pallina bianca
		if(potted(Game.getGame().whiteball)){
			JOptionPane.showMessageDialog(null, "Palla bianca imbucata, meh");
			Game.getGame().whiteball.x = 100;
			Game.getGame().whiteball.y = 123;
			stopBalls();
		}
        //Palline colorate
		for(Ball b: Game.getGame().balls) {
			if(potted(b)) {
				JOptionPane.showMessageDialog(null, "figo");
				b.x = 100;
				b.y = 123;
				stopBalls();
				Game.getGame().point();
			}
		}
	}
	//Controlla se la palla è andata in buca, confrontando con tutte le buche
	private static boolean potted(Ball b) {
		for(Pot p: Game.getGame().pots) {
			if (potted(b, p))
				return true;
		}
			
		return false;
	}
	//Confronto una pallina con una buca, simile al confronto di collisione
	private static boolean potted(Ball b, Pot p) {
		double x1 = b.x + b.getR();
		double x2 = p.getX() + p.getR();
		
		double y1 = b.y + b.getR();
		double y2 = p.getY() + p.getR();
		
		double distanceSquared = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
		
		return distanceSquared <= (b.getR() + p.getR()) * (b.getR() + p.getR());
		
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
		b1.convertBoolVec();
		b2.convertBoolVec();
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
		
		b1.convertVecBool();
		b2.convertVecBool();
		
	}
	
	private static void stopBalls() {
		//Fermo la pallina bianca
		Game.getGame().whiteball.vx = 0;
		Game.getGame().whiteball.vy = 0;
		//Fermo tutte le altre palline
		for(Ball b: Game.getGame().balls) {
			b.vx = 0;
			b.vy = 0;
		}
	}
	
	
}
