package colorpool.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import colorpool.config.Settings;
import colorpool.control.StartListener;

public class StartPanel extends JPanel {
	private Image background;
	
	private void initImages() {
		
		
		try {
			background = ImageIO.read(getClass().getClassLoader().getResource("resources/start/1.png"));
		} catch (IOException e) {
			Settings.throwError(4);
		}
	}
	public StartPanel(ColorPoolFrame frame) {
		super();
		initImages();
		StartListener listener = new StartListener(frame);
		addKeyListener(listener);
		addMouseListener(listener);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
	}
	
	private static final long serialVersionUID = 5913352926465412444L;

}
