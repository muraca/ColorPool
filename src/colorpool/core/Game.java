package colorpool.core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import colorpool.config.Settings;

public class Game {
	public WhiteBall whiteball;
	public ArrayList<Ball> balls;
	public int points;
	private static Game game = null;
	
	public Game(int p) {
		points = p;
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
	
	private void generateBalls() {
		whiteball = randomWhiteBall();
		balls.add(randomBall(Color.RED));
		balls.add(randomBall(Color.ORANGE));
		balls.add(randomBall(Color.YELLOW));
		balls.add(randomBall(Color.GREEN));
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
		for(Ball b: balls) {
			if(Movements.ballsCollide(whiteball, b)) {
				b = randomBall(b.getColor());
			}
		}
		
	}
}
