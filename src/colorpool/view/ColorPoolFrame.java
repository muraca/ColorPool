package colorpool.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import colorpool.config.Settings;
import colorpool.control.*;
import colorpool.testbutton.*;
import colorpool.threads.GameLoop;

public class ColorPoolFrame extends JFrame {
	public ColorPoolFrame() {
		super();
		
		
		
	}
	
	
	
	
	public void menuScreen() {
		this.getContentPane().removeAll();
		MenuPanel panel = new MenuPanel();
		panel.addMenuListener(new MenuListener());
		this.add(panel);
	}
	
	public void training() {
		getContentPane().removeAll();
		
		GamePanel panel = new GamePanel();
        
        TestButton testb = new TestButton();
        testb.addActionListener(new TestButtonListener());
        testb.setBounds(Settings.WIDTH-250, 0, 100, 30);
        
        panel.setLayout(null);
        panel.add(testb);
        
        GameListener gl=new GameListener(panel);
        panel.addMouseListener(gl);
        panel.addMouseMotionListener(gl);
        panel.setFocusable(true);//attivo il focus
            
        add(panel);
        
        GameLoop gameLoop = new GameLoop(panel);
		Thread t = new Thread(gameLoop);
		t.start();
	}
	
	
	
	
	private static final long serialVersionUID = 588260456005796541L;
	

}
