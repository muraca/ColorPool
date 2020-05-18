package colorpool.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

import colorpool.config.Settings;
import colorpool.control.*;

public class ColorPoolPanel extends JPanel{
	public CardLayout layout;
	private StartPanel start;
	private MenuPanel menu;
	
	public volatile Thread thread;
	
	public ColorPoolPanel () {
		
		layout = new CardLayout();
		
		start = new StartPanel();
		start.addStartListener(new StartListener(this));
		
		menu = new MenuPanel();
		menu.addMenuListener(new MenuListener(this));
		
		this.setLayout(layout);
		this.add(start, Settings.START);
		this.add(menu, Settings.MENU);
		
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
	
	public void stop() {
		thread = null;
	}
	
	private static final long serialVersionUID = -3857772597064017950L;

}
