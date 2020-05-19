package colorpool.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;

import colorpool.control.MenuListener;

public class MenuPanel extends JPanel{
	private Image backgroundImg;
	private JButton trainingButton;
	
	public MenuPanel() {
		backgroundImg = Toolkit.getDefaultToolkit().getImage("src/resources/background/pool.png");
		
		trainingButton = MenuButton.trainingButton((ColorPoolFrame) this.getParent());
		
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
