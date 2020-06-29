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
    private JTextField text1;
    private JTextField text2;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Pictures.getPictures().getBackground(), 0, 0, null);
		
		drawBalls(g);
		drawPath(g);
        points(g);
	}
	
	//inizializzazione dei vari componenti sfondo e testo
	public GamePanel() {
		super();
		this.setLayout(null);  //indispensabile per il posizionamento corretto di bottoni, label, ecc
		
		initText();
    	
		this.add(GameButtons.homeButton(ColorPoolFrame.getFrame(), Settings.WIDTH-180, 10));
		
    	GameListener gl = new GameListener(this);
    	this.addMouseListener(gl);
        this.addMouseMotionListener(gl);
    	
	}
	
	//inizializzazione del testo del punteggio
	private void initText() {
		text1 = new JTextField("");
    	text1.setBounds(135, 17, 150, 30);
    	text1.setForeground(Color.BLUE);
		
		text1.setFont(BitBold.getFont().deriveFont(Font.BOLD, 25f));
		
    	text1.setOpaque(false);
    	text1.setBorder(null);
    	text1.setEditable(false);
    	this.add(text1);
    	
    	text2 = new JTextField("");
    	text2.setBounds(776, 17, 150, 30);
    	text2.setForeground(Color.RED);
		
		text2.setFont(BitBold.getFont().deriveFont(Font.BOLD, 25f));
		
    	text2.setOpaque(false);
    	text2.setBorder(null);
    	text2.setEditable(false);
    	this.add(text2);
    	
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
            g.setColor(p.getColor());
            g.drawLine((int)Game.getGame().getWhiteBall().getX()+Settings.WHITEBALLDIMENSION/2,(int) Game.getGame().getWhiteBall().getY()+Settings.WHITEBALLDIMENSION/2,(int)p.getX(),(int)p.getY());
        }
    }
    
    //scrittura punteggio
    private void points(Graphics g) {
    	text1.setText(Integer.toString(Game.getGame().getPoints1()));
    	int startx = text1.getX() + 50;
    	for(Ball pottedBall: Game.getGame().getPottedBalls1()) {
    		g.drawImage(Pictures.getPictures().getBall(pottedBall.getColor()), startx, text1.getY(), null);
    		startx += Settings.BALLDIMENSION + 5;
    	}
    	
    	if(Game.getGame().gamemode() == Game.MULTIPLAYER)
    		text2.setText(Integer.toString(Game.getGame().getPoints2()));
    	startx = text2.getX() + 50;
    	for(Ball pottedBall: Game.getGame().getPottedBalls2()) {
    		g.drawImage(Pictures.getPictures().getBall(pottedBall.getColor()), startx, text1.getY(), null);
    		startx += Settings.BALLDIMENSION + 5;
    	}
    	
    }
    
    public void setPath(Path p) {
    	this.p = p;
    }
    
}
