package colorpool.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import colorpool.control.MenuListener;

public class MenuPanel extends JPanel{
	private Image backgroundImg;
	
	public MenuPanel() {
		backgroundImg = Toolkit.getDefaultToolkit().getImage("src/resources/background/pool.png");
	}
	
	public void addMenuListener(MenuListener listener) {
		this.addMouseListener(listener);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImg, 0, 0, null);
	}
	
	private static final long serialVersionUID = 6023735830414114292L;

}
