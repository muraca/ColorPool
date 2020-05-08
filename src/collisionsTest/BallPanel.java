package collisionsTest;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BallPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public static TestBall[] balls;
	public static int balls_size;
	
	public BallPanel() {
		super();
		super.setBackground(Color.GRAY);
	}
	
	public void setBalls(TestBall[] b, int _bs) {
		balls = b;
		balls_size = _bs;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(TestBall b: balls) {
			g.setColor(b.getColor());
			g.fillOval((int) b.getX(), (int) b.getY(), (int) b.getD(), (int) b.getD());
		}
	}
	

}
