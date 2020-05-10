package colorpool.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JTextField;

import colorpool.config.Settings;
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
        write(g);
	}
	
	public GamePanel() {
		super();
		backgroundImg = Toolkit.getDefaultToolkit().getImage("src/resources/pool.png");
		
    	text = new JTextField(Integer.toString(Game.getGame().points) + " points");
    	text.setBounds(150, 0, 100, 30);
    	text.setForeground(Color.WHITE);
    	text.setOpaque(false);
    	text.setBorder(null);
    	text.setEditable(false);
    	this.add(text);
	}
	
	private void drawBalls(Graphics g) {
        
		Image img = Toolkit.getDefaultToolkit().getImage("resources/whiteball.png");
			g.drawImage(img, (int) Game.getGame().whiteball.getX(), (int) Game.getGame().whiteball.getY(), null);
        
		for(Ball b: Game.getGame().balls) {
			
			if(b.getColor()==Color.RED) 
				img = Toolkit.getDefaultToolkit().getImage("resources/redball.png");
			else if(b.getColor() == Color.ORANGE)
				img = Toolkit.getDefaultToolkit().getImage("resources/orangeball.png");
			else if(b.getColor() == Color.YELLOW)
				img = Toolkit.getDefaultToolkit().getImage("resources/yellowball.png");
			else if(b.getColor() == Color.GREEN)
				img = Toolkit.getDefaultToolkit().getImage("resources/greenball.png");
			else if(b.getColor() == Color.CYAN)
				img = Toolkit.getDefaultToolkit().getImage("resources/cyanball.png");
			else if(b.getColor() == Color.BLUE)
				img = Toolkit.getDefaultToolkit().getImage("resources/blueball.png");
			else if(b.getColor() == Color.MAGENTA)
				img = Toolkit.getDefaultToolkit().getImage("resources/purpleball.png");
			
			g.drawImage(img, (int) Math.round(b.getX()), (int) Math.round(b.getY()), null);
			
		}
	}
    
    private void drawPointer(Graphics g){
        if (p!=null) {
            g.setColor(Pointer.c);
            g.drawLine((int)Game.getGame().whiteball.getX()+Settings.WHITEBALLDIMENSION/2,(int) Game.getGame().whiteball.getY()+Settings.WHITEBALLDIMENSION/2,(int)p.x,(int)p.y);
            g.fillOval((int)p.x - Pointer.dimension/2, (int)p.y - Pointer.dimension/2, Pointer.dimension, Pointer.dimension);
        }
    }
    
    private void write(Graphics g) {
    	text.setText(Integer.toString(Game.getGame().points) + " points");
    }
}
