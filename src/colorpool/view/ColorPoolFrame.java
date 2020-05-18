package colorpool.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import colorpool.GameLoop;
import colorpool.config.Settings;
import colorpool.control.*;
import colorpool.testbutton.*;

public class ColorPoolFrame extends JFrame {
	private Dimension dim;
	public ColorPoolFrame() {
		super();
		
		setSize(Settings.WIDTH, Settings.HEIGHT+20);
		dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        startScreen();
		
	}
	
	public void startScreen() {
		System.out.println("StartScreen");
		this.getContentPane().removeAll();
		StartPanel panel = new StartPanel();
		panel.addStartListener(new StartListener());
		this.add(panel);
		System.out.println("Added");
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
