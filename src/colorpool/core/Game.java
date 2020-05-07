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
	
	public Game() {
		Random r = new Random();
		whiteball = new WhiteBall(r.nextInt(Settings.WIDTH), r.nextInt(Settings.HEIGHT));
		Ball redball = new Ball(r.nextInt(Settings.WIDTH), r.nextInt(Settings.HEIGHT), Color.RED);
		balls.add(redball);
		
	}
	public boolean canShot() {
		for(Ball b: balls) {
			if(b.vx!=0||b.vy!=0)
				return false;
		}
		if(whiteball.vx!=0||whiteball.vy!=0)
			return false;
		return true;
	}
}
