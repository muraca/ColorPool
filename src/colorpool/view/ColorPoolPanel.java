package colorpool.view;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import colorpool.control.*;
import colorpool.threads.Loop;

public class ColorPoolPanel extends JFrame{
	private CardLayout layout;
	private Container container;
	private StartPanel startP;
	private MenuPanel menuP;
	
	public volatile Thread thread;
	
	public ColorPoolPanel () {
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
		menuP.addMenuListener(new MenuListener(this));
		container.add("menu", menuP);
		layout.show(container, "menu");
		thread = new Thread(new Loop(menuP));
		run();
	}
	
	private static final long serialVersionUID = -3857772597064017950L;

}
