package colorpool.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTextField;

import colorpool.config.Settings;
import colorpool.control.GameListener;
import colorpool.core.*;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
    
    public Pointer p;
    private JTextField text;
    private Image backgroundImg;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImg, 0, 0, null);
		
		drawBalls(g);
        drawPointer(g);
        points(g);
	}
	
	//inizializzazione dei vari componenti sfondo e testo
	public GamePanel() {
		super();
		this.setLayout(null);  //indispensabile per il posizionamento corretto di bottoni, label, ecc
		backgroundImg = Toolkit.getDefaultToolkit().getImage("src/resources/background/pool.png");
		text = new JTextField(Integer.toString(Game.getGame().points));
    	text.setBounds(135, 17, 150, 30);
    	text.setForeground(Color.BLUE);
		
		text.setFont(BitBold.getFont().deriveFont(Font.BOLD, 25f));
		
    	text.setOpaque(false);
    	text.setBorder(null);
    	text.setEditable(false);
    	this.add(text);
    	
    	GameListener gl = new GameListener(this);
    	this.addMouseListener(gl);
        this.addMouseMotionListener(gl);
    	
	}
	
	//disegna le palline all'interno del campo
	private void drawBalls(Graphics g) {
		g.drawImage(Pictures.getInstance().getBall(Color.WHITE), (int) Game.getGame().whiteball.getX(), (int) Game.getGame().whiteball.getY(), null);
        
		for(Ball b: Game.getGame().balls) {
			g.drawImage(Pictures.getInstance().getBall(b.getColor()), (int) Math.round(b.getX()), (int) Math.round(b.getY()), null);
		}
	}
    
	//disegna il puntatore
    private void drawPointer(Graphics g){
        if (p!=null) {
            g.setColor(Pointer.c);
            g.drawLine((int)Game.getGame().whiteball.getX()+Settings.WHITEBALLDIMENSION/2,(int) Game.getGame().whiteball.getY()+Settings.WHITEBALLDIMENSION/2,(int)p.x,(int)p.y);
            g.fillOval((int)p.x - Pointer.dimension/2, (int)p.y - Pointer.dimension/2, Pointer.dimension, Pointer.dimension);
        }
    }
    
    //scrittura punteggio
    private void points(Graphics g) {
    	text.setText(Integer.toString(Game.getGame().points));
    	int startx = text.getX() + 50;
    	for(Ball pottedBall: Game.getGame().pottedBalls) {
    		g.drawImage(Pictures.getInstance().getBall(pottedBall.getColor()), startx, text.getY(), null);
    		startx += Settings.BALLDIMENSION + 5;
    	}
    }
}
