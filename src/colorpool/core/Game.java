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
		pots.add(new Pot(0, Settings.HEIGHT-Pot.getDimension()));
		pots.add(new Pot(Settings.WIDTH/2 - Pot.getDimension()/2, 0));
		pots.add(new Pot(Settings.WIDTH/2 - Pot.getDimension()/2, Settings.HEIGHT-Pot.getDimension()));
		pots.add(new Pot(Settings.WIDTH - Pot.getDimension(), 0));
		pots.add(new Pot(Settings.WIDTH - Pot.getDimension(), Settings.HEIGHT-Pot.getDimension()));
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
		
		initialControl();
		
	}
	
	private WhiteBall randomWhiteBall() {
		Random r = new Random();
		return new WhiteBall(r.nextInt(Settings.WIDTH), r.nextInt(Settings.HEIGHT));
	}
	
	private Ball randomBall(Color c) {
		Random r = new Random();
		return new Ball(r.nextInt(Settings.WIDTH), r.nextInt(Settings.HEIGHT), c);
	}
	
	private void initialControl() {
        boolean recontrol = false;
		for(Ball b: balls) {
			if(Movements.ballsCollide(whiteball, b)) {
				b.x += 40;
				b.y += 40;
                recontrol = true;
			}
		}
        
        for(int i=0; i<balls.size() - 1; i++) {
            for(int j=i+1; j<balls.size(); j++) {
                if(Movements.ballsCollide(balls.get(i),balls.get(j))) {
                    balls.get(j).x += 75;
                    balls.get(j).y += 75;
                    recontrol = true;
                }
            }
        }
        
		if(recontrol)
            initialControl();
	}
    
    public void point(){
        points++;
        game = new Game(points);
    }
}
