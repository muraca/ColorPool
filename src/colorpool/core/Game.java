package colorpool.core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import colorpool.config.Settings;
import colorpool.view.ColorPoolFrame; 

public class Game {
	public WhiteBall whiteball;
	public ArrayList<Ball> balls;
	public ArrayList<Ball> pottedBalls;
	public int points;
	private static Game game = null;
	
	private Game(int _points) {
		this.points = _points;
		generateBalls();
		pottedBalls = new ArrayList<>();
	}
	
	private Game(int _points, ArrayList<Ball> pottedBalls) {
		this.points = _points;
		this.pottedBalls = pottedBalls;
		generateBalls();
	}
	
	public static Game getGame() {
		if(game == null)
			game = new Game(0);
		return game;
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
    
    public void pot(Ball pottedBall){
    	if(game!=null) { //TODO Lo tengo?
    		if(pottedBall.equalsTo(whiteball)) {
    			JOptionPane.showMessageDialog(null, "White ball potted!");
    			lose();
    			return;
    		}
    		for(Ball b: pottedBalls) {
    			if(b.equalsTo(pottedBall)) {
    				JOptionPane.showMessageDialog(null, "Wrong ball potted!");
    				lose();
    				return;
    			}
    		}
    		points++;
    		JOptionPane.showMessageDialog(null, "Good shot!");
    		pottedBalls.add(pottedBall);
    		if(pottedBalls.size()<balls.size())
    			game = new Game(points, pottedBalls);
    		else
    			game = new Game(points);
        }
    }
    
    private void lose() {
    	String[] options = {"Quit", "Play"};
    	int chosen = JOptionPane.showOptionDialog(null, "Do you want to play again?", "Game Over!",
    			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
    	if(chosen==0) {
    		game = null;
    		ColorPoolFrame.getFrame().menu();
    	}
    	else {
    		game = new Game(0);
    	}
    	
    	
    }

}