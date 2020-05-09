package colorpool.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import colorpool.config.Settings;
import colorpool.core.*;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
    
    public Pointer p;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBalls(g);
		drawPots(g);
        drawPointer(g);
	}
	
	private void drawBalls(Graphics g) {
        this.setBackground(Settings.POOLCOLOR);
        
        File imageFile = new File("resources/whiteball.png");
        Image img = null;
        try {
			img = ImageIO.read(imageFile);
			g.drawImage(img, (int) Game.getGame().whiteball.getX(), (int) Game.getGame().whiteball.getY(), null);
		} catch (IOException e) {
			// TODO Error stuffs
			//System.out.println("Image not found");
		}
		//g.fillOval((int) Game.getGame().whiteball.getX(), (int) Game.getGame().whiteball.getY(), Game.getGame().whiteball.getD(), Game.getGame().whiteball.getD());
		for(Ball b: Game.getGame().balls) {
			
			if(b.getColor()==Color.RED) 
				imageFile = new File("resources/redball.png");
			else if(b.getColor() == Color.ORANGE)
				imageFile = new File("resources/orangeball.png");
			else if(b.getColor() == Color.YELLOW)
				imageFile = new File("resources/yellowball.png");
			else if(b.getColor() == Color.GREEN)
				imageFile = new File("resources/greenball.png");
			else if(b.getColor() == Color.CYAN)
				imageFile = new File("resources/cyanball.png");
			else if(b.getColor() == Color.BLUE)
				imageFile = new File("resources/blueball.png");
			else if(b.getColor() == Color.MAGENTA)
				imageFile = new File("resources/purpleball.png");
			
			try {
				img = ImageIO.read(imageFile);
				g.drawImage(img, (int) b.getX(), (int) b.getY(), null);
			} catch (IOException e) {
				// TODO Error stuffs
				//System.out.println("Image not found");
			}	
			/*else {
				g.setColor(b.getColor());
				g.fillOval((int) b.getX(), (int) b.getY(), b.getD(), b.getD());
			}*/
		}
	}
	
	private void drawPots(Graphics g) {
		g.setColor(Color.BLACK);
		for(Pot p: Game.getGame().pots) {
			g.fillOval((int) p.getX(), (int) p.getY(), p.getDimension(), p.getDimension());
		}
	}
    
    private void drawPointer(Graphics g){
        if (p!=null) {
            g.setColor(Pointer.c);
            g.drawLine((int)Game.getGame().whiteball.getX()+Settings.WHITEBALLDIMENSION/2,(int) Game.getGame().whiteball.getY()+Settings.WHITEBALLDIMENSION/2,(int)p.x,(int)p.y);
            g.fillOval((int)p.x - Pointer.dimension/2, (int)p.y - Pointer.dimension/2, Pointer.dimension, Pointer.dimension);
        }
    }
}