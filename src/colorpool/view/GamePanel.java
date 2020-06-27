package colorpool.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

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
    private JTextField text;
    private Image backgroundImg;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImg, 0, 0, null);
		
		drawBalls(g);
		drawPath(g);
        points(g);
	}
	
	//inizializzazione dei vari componenti sfondo e testo
	public GamePanel() {
		super();
		this.setLayout(null);  //indispensabile per il posizionamento corretto di bottoni, label, ecc
		backgroundImg = Pictures.getPictures().getBackground();
		
		initText();
    	
		this.add(GameButtons.homeButton(ColorPoolFrame.getFrame(), Settings.WIDTH-180, 10));
		
    	GameListener gl = new GameListener(this);
    	this.addMouseListener(gl);
        this.addMouseMotionListener(gl);
    	
	}
	
	private void initText() {
		text = new JTextField(Integer.toString(Game.getGame().points));
    	text.setBounds(135, 17, 150, 30);
    	text.setForeground(Color.BLUE);
		
		text.setFont(BitBold.getFont().deriveFont(Font.BOLD, 25f));
		
    	text.setOpaque(false);
    	text.setBorder(null);
    	text.setEditable(false);
    	this.add(text);
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
    	text.setText(Integer.toString(Game.getGame().points));
    	int startx = text.getX() + 50;
    	for(Ball pottedBall: Game.getGame().getPottedBalls()) {
    		g.drawImage(Pictures.getPictures().getBall(pottedBall.getColor()), startx, text.getY(), null);
    		startx += Settings.BALLDIMENSION + 5;
    	}
    }
    
    public void setPath(Path p) {
    	this.p = p;
    }
    
}
