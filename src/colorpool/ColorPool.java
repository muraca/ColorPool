package colorpool;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import colorpool.config.Settings;
import colorpool.view.*;

public class ColorPool {

	public static void main(String[] args) {
		ColorPoolPanel colorF = new ColorPoolPanel();
		colorF.setSize(Settings.WIDTH, Settings.HEIGHT+20);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		colorF.setLocation(dim.width/2-colorF.getSize().width/2, dim.height/2-colorF.getSize().height/2);
		colorF.setVisible(true);
		colorF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		colorF.start();
		
	}
	
}
