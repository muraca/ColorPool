package colorpool.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JTextField;

import colorpool.buttons.GameButtons;
import colorpool.config.BitBold;
import colorpool.config.Pictures;
import colorpool.config.Settings;
import colorpool.control.GameListener;
import colorpool.core.*;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
    
    private Path p;
    private JTextField player1points;
    private JTextField player2points;
    private JTextField playerShooting;
	
	//inizializzazione dei vari componenti sfondo e testo
	public GamePanel() {
		super();
		this.setLayout(null);  //indispensabile per il posizionamento corretto di bottoni, label, ecc
		
		initPoints();
    	
		this.add(GameButtons.homeButton(Settings.WIDTH-180, 10));
		
    	GameListener gl = new GameListener(this);
    	this.addMouseListener(gl);
        this.addMouseMotionListener(gl);
	}
	
	//inizializzazione del testo del punteggio
	private void initPoints() {
		player1points = new JTextField("");
    	player1points.setBounds(135, 17, 150, 30);
    	if(Game.getGame().gamemode() == Game.MULTIPLAYER)
    		player1points.setForeground(Settings.player1color);
    	else
        	player1points.setForeground(Settings.singleplayercolor);
		
		player1points.setFont(BitBold.getFont().deriveFont(Font.BOLD, 25f));
		
    	player1points.setOpaque(false);
    	player1points.setBorder(null);
    	player1points.setEditable(false);
    	this.add(player1points);
    	
    	player2points = new JTextField("");
    	player2points.setBounds(776, 17, 150, 30);
    	player2points.setForeground(Settings.player2color);
		
		player2points.setFont(BitBold.getFont().deriveFont(Font.BOLD, 25f));
		
    	player2points.setOpaque(false);
    	player2points.setBorder(null);
    	player2points.setEditable(false);
    	this.add(player2points);
    	
    	playerShooting = new JTextField("");
    	
    	playerShooting.setBounds(135, 760, 300, 30);
		
    	playerShooting.setFont(BitBold.getFont().deriveFont(Font.BOLD, 25f));
		
    	playerShooting.setOpaque(false);
    	playerShooting.setBorder(null);
    	playerShooting.setEditable(false);
    	this.add(playerShooting);
	}
	
	//disegna le palline all'interno del campo
	private void drawBalls(Graphics g) {
		g.drawImage(Pictures.getPictures().getBall(Color.WHITE), (int) Game.getGame().getWhiteBall().getX(), (int) Game.getGame().getWhiteBall().getY(), null);
        
		for(Ball b: Game.getGame().getBalls()) {
			g.drawImage(Pictures.getPictures().getBall(b.getColor()), (int) Math.round(b.getX()), (int) Math.round(b.getY()), null);
		}
	}
    
	//disegna il puntatore
    private void drawPath(Graphics g){
        if (p!=null) {
        	if(Game.getGame().gamemode() == Game.SINGLEPLAYER)
        		g.setColor(Settings.singleplayercolor);
        	else if(Game.getGame().turn() == Game.PLAYER1)
        		g.setColor(Settings.player1color);
        	else
        		g.setColor(Settings.player2color);
            g.drawLine((int)Game.getGame().getWhiteBall().getX()+Settings.WHITEBALLDIMENSION/2,(int) Game.getGame().getWhiteBall().getY()+Settings.WHITEBALLDIMENSION/2,(int)p.getX(),(int)p.getY());
        }
    }
    
    //scrittura punteggio e turno 
    private void paintPoints(Graphics g) {
    	player1points.setText(Integer.toString(Game.getGame().getPoints1()));
    	
    	int startx = player1points.getX() + 50;
    	
    	for(Ball pottedBall: Game.getGame().getPottedBalls1()) {
    		g.drawImage(Pictures.getPictures().getBall(pottedBall.getColor()), startx, player1points.getY(), null);
    		startx += Settings.BALLDIMENSION + 5;
    	}
    	
    	if(Game.getGame().gamemode() == Game.MULTIPLAYER) {
    		player2points.setText(Integer.toString(Game.getGame().getPoints2()));
    	
    		startx = player2points.getX() + 50;
    		
    		for(Ball pottedBall: Game.getGame().getPottedBalls2()) {
    			g.drawImage(Pictures.getPictures().getBall(pottedBall.getColor()), startx, player1points.getY(), null);
    			startx += Settings.BALLDIMENSION + 5;
    		}
    		
    		if(Game.getGame().turn() == Game.PLAYER1) {
    			playerShooting.setForeground(Settings.player1color);
    			playerShooting.setText("Player 1's turn");
    		}
    		else {
    			playerShooting.setForeground(Settings.player2color);
    			playerShooting.setText("Player 2's turn");
    		}
    				
    	}
    	else {
			playerShooting.setForeground(Settings.singleplayercolor);
			playerShooting.setText("Training mode");
    	}
    }
    
    public void setPath(Path p) {
    	this.p = p;
    }
    
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Pictures.getPictures().getBackground(), 0, 0, null);
		
		drawBalls(g);
		drawPath(g);
        paintPoints(g);
	}
    
}
