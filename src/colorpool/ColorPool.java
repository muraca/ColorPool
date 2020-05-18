package colorpool;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import colorpool.config.Settings;
import colorpool.threads.StartLoop;
import colorpool.view.*;

public class ColorPool {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(Settings.WIDTH, Settings.HEIGHT+20);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ColorPoolPanel colorP = new ColorPoolPanel();
        f.add(colorP);
        
        colorP.layout.show(colorP, "start");
        colorP.thread = new Thread(new StartLoop(colorP.getStart()));
        colorP.run(); 
	}
	
}
