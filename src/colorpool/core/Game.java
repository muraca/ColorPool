package colorpool.core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

import colorpool.config.Pictures;
import colorpool.config.Settings;
import colorpool.view.ColorPoolFrame;
import colorpool.view.MyOptionPane;
public class Game {
	//modalità di gioco, singleplayer o multiplayer
	public final static boolean SINGLEPLAYER = false;
	public final static boolean MULTIPLAYER = true;
	private boolean gamemode;
	
	//variabile che 
	public final static boolean PLAYER1 = false;
	public final static boolean PLAYER2 = true;
	private boolean turn;
	
	
	private WhiteBall whiteball;
	private ArrayList<Ball> balls;
	
	private ArrayList<Ball> pottedBalls1;
	private ArrayList<Ball> pottedBalls2;
	private int points1;
	private int points2;
	
	private static Game game = null;
	
	private Game(int p1) {
		points1 = p1;
		pottedBalls1 = new ArrayList<>();
		gamemode = SINGLEPLAYER;
		turn = PLAYER1;
		
		pottedBalls2 = new ArrayList<>(); //per evitare nullpointer exceptions

		generateBalls();
	}
	
	private Game(int p1, int p2) {
		points1 = p1;
		points2 = p2;
		pottedBalls1 = new ArrayList<>();
		pottedBalls2 = new ArrayList<>();
		gamemode = MULTIPLAYER;
		turn = PLAYER1;

		generateBalls();
	}
	
	private Game(int p1, ArrayList<Ball> pB1) {
		points1 = p1;
		pottedBalls1 = pB1;
		gamemode = SINGLEPLAYER;
		turn = PLAYER1;
		
		pottedBalls2 = new ArrayList<>(); //per evitare nullpointer exceptions
		
		generateBalls();
	}
	
	private Game(int p1, ArrayList<Ball> pB1, int p2, ArrayList<Ball> pB2) {
		points1 = p1;
		pottedBalls1 = pB1;
		points2 = p2;
		pottedBalls2 = pB2;
		gamemode = MULTIPLAYER;
		turn = PLAYER1;
		
		generateBalls();
	}
	
	private Game(int p1, ArrayList<Ball> pB1, int p2, ArrayList<Ball> pB2, boolean nextTurn) {
		points1 = p1;
		pottedBalls1 = pB1;
		points2 = p2;
		pottedBalls2 = pB2;
		gamemode = MULTIPLAYER;
		turn = nextTurn;
		
		generateBalls();
	}
	
	public static Game getGame() {
		return game;
	}
	
	public static void initGame(boolean gamemode) {
		if(gamemode == SINGLEPLAYER)
			game = new Game(0);
		else
			game = new Game(0, 0);
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

	public WhiteBall getWhiteBall() {
		return whiteball;
	}
	public ArrayList<Ball> getBalls() {
		return balls;
	}

	public ArrayList<Ball> getPottedBalls1() {
		return pottedBalls1;
	}
	
	public ArrayList<Ball> getPottedBalls2() {
		return pottedBalls2;
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
    	if(game!=null) { 
    		if(pottedBall.equalsTo(whiteball)) {
    			lose(whiteball);
    		}
    		else {
    			for(Ball b: pottedBalls1) {
    				if(b.equalsTo(pottedBall)) {
    					lose(b);
    					return;
    				}
    			}
    			Movements.stopBalls();
    			MyOptionPane.pottedBallPane(new ImageIcon(Pictures.getPictures().getBall(pottedBall.getColor())), true);
    			if(turn == PLAYER1) {
    				pottedBalls1.add(pottedBall);
    				points1++;
    				if(pottedBalls1.size()<balls.size())
    					game = new Game(points1, pottedBalls1, points2, pottedBalls2, gamemode); //se gamemode è true allora sarà il turno del player2, altrimenti tira ancora player1
    				else
    					game = new Game(points1, new ArrayList<Ball>(), points2, pottedBalls2, gamemode);
    			}
    			else {
    				pottedBalls2.add(pottedBall);
    				points2++;
    				if(pottedBalls2.size()<balls.size())
    					game = new Game(points1, pottedBalls1, points2, pottedBalls2, false);
    				else
    					game = new Game(points1, pottedBalls1, points2, new ArrayList<Ball>(), false);
    				
    			}
    				
    		}
    	}
    }
    
    private void lose(Ball pottedBall) {
    	Movements.stopBalls();
		MyOptionPane.pottedBallPane(new ImageIcon(Pictures.getPictures().getBall(pottedBall.getColor())), false);
		
    	if(MyOptionPane.gameOverPane() == 0) 
    		ColorPoolFrame.getFrame().stopGame();
    	
    	else if(gamemode == SINGLEPLAYER)
    		game = new Game(0);
    	
    	else
    		game = new Game(0, 0);
    	
    	
    	
    }
    
    public static void home() {
    	if(MyOptionPane.homebuttonPane() == 0) {
    		ColorPoolFrame.getFrame().stopGame();
    	}
    	
    }

	public static void deleteGame() {
		game = null;
	}

	public int getPoints1() {
		return points1;
	}
	
	public int getPoints2() {
		return points2;
	}

	
	public boolean gamemode() {
		return gamemode;
	}
	
	public boolean turn() {
		return turn;
	}
}