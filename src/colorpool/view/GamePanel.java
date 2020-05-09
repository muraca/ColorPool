package colorpool.view;

import java.awt.Color;
import java.awt.Graphics;

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
		g.setColor(Color.WHITE);
		g.fillOval((int) Game.getGame().whiteball.getX(), (int) Game.getGame().whiteball.getY(), Game.getGame().whiteball.getD(), Game.getGame().whiteball.getD());
		for(Ball b: Game.getGame().balls) {
			g.setColor(b.getColor());
			g.fillOval((int) b.getX(), (int) b.getY(), b.getD(), b.getD());
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
