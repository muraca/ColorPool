package colorpool;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import colorpool.config.*;
import colorpool.control.*;
import colorpool.core.Movements;
import colorpool.view.*;

public class Main {
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(Settings.WIDTH, Settings.HEIGHT);
		GamePanel panel = new GamePanel();
		panel.addMouseListener(new GameListener(panel));
		panel.setFocusable(true);
		f.add(panel);
		f.setUndecorated(true); // Remove title bar
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Movements.moveBalls();
			panel.repaint();
		}
	}
}
