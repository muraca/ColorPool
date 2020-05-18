package colorpool.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

import colorpool.control.StartListener;

public class StartPanel extends JPanel {
	private int now;
	private ArrayList<Image> images;
	
	private void initImages() {
		images = new ArrayList<>();
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/start1.png"));
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/start2.png"));
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/start3.png"));
		images.add(Toolkit.getDefaultToolkit().getImage("src/resources/start4.png"));
	}
	public StartPanel() {
		initImages();
		now = 0;
		run();
	}
	
	private void run() {
		repaint();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO errors stuff
		}
	}
	
	public void addStartListener(StartListener listener) {
		addKeyListener(listener);
		addMouseListener(listener);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(images.get(now), 0, 0, null);
		now++;
		if(now == images.size())
			now = 0;
	}
	
	private static final long serialVersionUID = 5913352926465412444L;

}
