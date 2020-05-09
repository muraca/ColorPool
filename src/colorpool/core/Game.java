package colorpool.core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import colorpool.config.Settings;

public class Game {
	public WhiteBall whiteball;
	public ArrayList<Ball> balls;
	public ArrayList<Pot> pots;
	public int points;
	private static Game game = null;
	
	public Game(int p) {
		this.points = p;
		generatePots();
		generateBalls();
	}
	
	public static Game getGame() {
		if(game == null)
			game = new Game(0);
		return game;
	}
	
	public static void restartGame() {
		game = new Game(0);
	}
	
	public boolean canShot() {
		if(whiteball.vx!=0||whiteball.vy!=0)
			return false;
		for(Ball b: balls) {
			if(b.vx!=0||b.vy!=0)
				return false;
		}
		return true;
	}
	
	private void generatePots() {
		pots = new ArrayList<>();
		
		pots.add(new Pot(0, 0));
		pots.add(new Pot(0, Settings.HEIGHT - Settings.POTDIMENSION));
		pots.add(new Pot(Settings.WIDTH/2 - Settings.POTDIMENSION/2, 0));
		pots.add(new Pot(Settings.WIDTH/2 - Settings.POTDIMENSION/2, Settings.HEIGHT-Settings.POTDIMENSION));
		pots.add(new Pot(Settings.WIDTH - Settings.POTDIMENSION, 0));
		pots.add(new Pot(Settings.WIDTH - Settings.POTDIMENSION, Settings.HEIGHT-Settings.POTDIMENSION));
	}
	
	
	private void generateBalls() {
		whiteball = randomWhiteBall();
		
		balls = new ArrayList<>();
		balls.add(randomBall(Color.RED));
		balls.add(randomBall(Color.ORANGE));
		balls.add(randomBall(Color.YELLOW));
		balls.add(randomBall(Color.BLACK));
		balls.add(randomBall(Color.BLUE));
		balls.add(randomBall(Color.CYAN));
		balls.add(randomBall(Color.MAGENTA));
		
		initialControl(true);
		
	}
	
	private WhiteBall randomWhiteBall() {
		Random r = new Random();
		return new WhiteBall(r.nextInt(Settings.WIDTH-Settings.WHITEBALLDIMENSION), r.nextInt(Settings.HEIGHT-Settings.WHITEBALLDIMENSION));
	}
	
	private Ball randomBall(Color c) {
		Random r = new Random();
		return new Ball(r.nextInt(Settings.WIDTH-Settings.BALLDIMENSION), r.nextInt(Settings.HEIGHT-Settings.BALLDIMENSION), c);
	}
	
	private void initialControl(boolean control) {
		for(Pot p: pots) {
			while(Movements.potted(whiteball, p))
				whiteball = randomWhiteBall();
			for(Ball b: balls) {
				while(Movements.potted(b, p))
					b = randomBall(b.color);
			}
		}
        
		for(Ball b: balls) {
			if(Movements.ballsCollide(whiteball, b)) {
				b.x += b.color.getRGB();
				b.y += b.color.getRGB();
			}
			
		}
        
        for(int i=0; i<balls.size() - 1; i++) {
            for(int j=i+1; j<balls.size(); j++) {
                if(Movements.ballsCollide(balls.get(i),balls.get(j))) {
                    balls.get(j).x += balls.get(i).color.getRGB();
                    balls.get(j).y += balls.get(i).color.getRGB();
                }
            }
        }
        if(control)
        	initialControl(false);
	}
    
    public void point(){
        points++;
        game = new Game(points);
    }
}
