package colorpool;

import javax.swing.JFrame;

import colorpool.config.*;
import colorpool.control.*;
import colorpool.testbutton.*;
import colorpool.view.*;

public class Main {
	
	public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(Settings.WIDTH, Settings.HEIGHT);
        
        
        GamePanel panel = new GamePanel();
        
        TestButton testb = new TestButton();
        testb.addActionListener(new TestButtonListener());
        
        panel.add(testb);
        
        GameListener gl=new GameListener(panel);
        panel.addMouseListener(gl);
        panel.addMouseMotionListener(gl);
        panel.setFocusable(true);//attivo il focus
        
        
        f.add(panel);
        f.setUndecorated(true); // Remove title bar
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ThreadAnimations t =  new ThreadAnimations(panel);
        t.run();
	}
    
}
