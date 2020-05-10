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
		this.points = p;
		generateBalls();
	}
	
	public static Game getGame() {
		if(game == null)
			game = new Game(0);
		return game;
	}
	
	public void restartGame() {
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
		
		balls = new ArrayList<>();
		balls.add(randomBall(Color.RED));
		balls.add(randomBall(Color.ORANGE));
		balls.add(randomBall(Color.YELLOW));
		balls.add(randomBall(Color.GREEN));
		balls.add(randomBall(Color.BLUE));
		balls.add(randomBall(Color.CYAN));
		balls.add(randomBall(Color.MAGENTA));
		
		initialControl(true);
		
	}
	
	private WhiteBall randomWhiteBall() {
		Random r = new Random();
		int difference = Settings.WHITEBALLDIMENSION*4 + Settings.POOLMINX;
		return new WhiteBall(r.nextInt(Settings.POOLMAXX-difference)+2*Settings.POOLMINX, r.nextInt(Settings.POOLMAXY-difference)+2*Settings.POOLMINY);
	}
	
	private Ball randomBall(Color c) {
		Random r = new Random();
		int difference = Settings.BALLDIMENSION*4 + Settings.POOLMINX;
		return new Ball(r.nextInt(Settings.POOLMAXX-difference)+2*Settings.POOLMINX, r.nextInt(Settings.POOLMAXY-difference)+2*Settings.POOLMINY, c);
	}
	
	private void initialControl(boolean control) {
        
		for(Ball b: balls) {
			if(Movements.ballsCollide(whiteball, b)) {
				b.x += b.getD();
				b.y += b.getD();
			}
		}
        
        for(int i=0; i<balls.size() - 1; i++) {
            for(int j=i+1; j<balls.size(); j++) {
                if(Movements.ballsCollide(balls.get(i),balls.get(j))) {
                   balls.get(j).x += balls.get(i).getD()*j;
                   balls.get(j).y += balls.get(i).getD()*j;
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