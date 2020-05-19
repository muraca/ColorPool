package colorpool.view;


import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;

import colorpool.config.Settings;
import colorpool.control.*;
import colorpool.testbutton.*;
import colorpool.threads.GameLoop;
import colorpool.threads.Loop;

public class ColorPoolFrame extends JFrame {
	private CardLayout layout;
	private Container container;
	private StartPanel startP;
	private MenuPanel menuP;
	
	public volatile Thread thread;
	
	public ColorPoolFrame() {
		super();
		container = getContentPane();
		layout = new CardLayout();
		container.setLayout(layout);
		
	}
	
	public StartPanel getStart() {
		return startP;
	}
	
	public MenuPanel getMenu() {
		return menuP;
	}
	
	
	public void run() {
		if(thread != null) {
			thread.start();
		}
	}
	
	public void stop() {
		thread = null;
	}
	
	public void start() {
		startP = new StartPanel();
		startP.setFocusable(true);
		StartListener sl = new StartListener(this);
		startP.addStartListener(sl);
		container.add("start", startP);
		layout.show(container, "start");
		thread = new Thread(new Loop(startP));
		run(); 
	}
	
	public void menu() {
		menuP = new MenuPanel();
		startP.setFocusable(true);
		menuP.addMenuListener(new MenuListener(this));
		container.add("menu", menuP);
		layout.show(container, "menu");
		thread = new Thread(new Loop(menuP));
		run();
	}
	
	public void training() {
		//getContentPane().removeAll();
		
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
            
        container.add("game", panel);
        layout.show(container, "game");
		thread = new Thread(new GameLoop(panel));
		run();
	}
	
	
	
	private static final long serialVersionUID = 588260456005796541L;
	

}
