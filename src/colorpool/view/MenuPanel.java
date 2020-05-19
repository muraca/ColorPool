package colorpool.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import colorpool.control.MenuListener;

public class MenuPanel extends JPanel{
	private Image backgroundImg;
	private Image buttonBkg;
	private JButton trainingButton;
	
	public MenuPanel() {
		backgroundImg = Toolkit.getDefaultToolkit().getImage("src/resources/background/pool.png");
		buttonBkg = Toolkit.getDefaultToolkit().getImage("src/resources/menu/button.png");
		trainingButton = new JButton(new ImageIcon(buttonBkg));
		trainingButton.setOpaque(false);
		trainingButton.setBorder(BorderFactory.createEmptyBorder());
		this.add(trainingButton);
		
	}
	
	public void addMenuListener(MenuListener listener) {
		trainingButton.addActionListener(listener);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImg, 0, 0, null);
	}
	
	private static final long serialVersionUID = 6023735830414114292L;

}
