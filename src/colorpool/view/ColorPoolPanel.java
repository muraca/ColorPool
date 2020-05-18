package colorpool.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

import colorpool.control.*;

public class ColorPoolPanel extends JPanel{
	public CardLayout layout;
	private StartPanel start;
	private MenuPanel menu;
	
	public Thread thread;
	
	public ColorPoolPanel () {
		
		layout = new CardLayout();
		
		start = new StartPanel();
		start.addStartListener(new StartListener(this));
		
		menu = new MenuPanel();
		
		this.setLayout(layout);
		this.add(start, "start");
		this.add(menu, "menu");
		
	}
	
	public StartPanel getStart() {
		return start;
	}
	
	public MenuPanel getMenu() {
		return menu;
	}
	
	
	public void run() {
		if(thread != null)
			thread.run();
	}
	
	private static final long serialVersionUID = -3857772597064017950L;
}
