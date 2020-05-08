package colorpool.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import colorpool.core.*;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBalls(g);
		drawPots(g);
	}
	
	private void drawBalls(Graphics g) {
		g.setColor(Color.WHITE);
		this.setBackground(Color.GREEN);
		g.fillOval(Game.getGame().whiteball.getX(), Game.getGame().whiteball.getY(), Game.getGame().whiteball.getD(), Game.getGame().whiteball.getD());
		for(Ball b: Game.getGame().balls) {
			g.setColor(b.getColor());
			g.fillOval(b.getX(), b.getY(), b.getD(), b.getD());
		}
	}
	
	private void drawPots(Graphics g) {
		this.setBackground(Color.GREEN);
		g.setColor(Color.BLACK);
		for(Pot p: Game.getGame().pots) {
			g.fillOval(p.getX(), p.getY(), Pot.getDimension(), Pot.getDimension());
		}
	}
}
