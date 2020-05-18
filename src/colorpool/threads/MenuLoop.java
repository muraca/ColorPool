package colorpool.threads;

import colorpool.view.MenuPanel;

public class MenuLoop implements Runnable {

	public MenuPanel panel;
		
	public MenuLoop(MenuPanel panel) {
		this.panel = panel;
			
	}
		
	public void run() {
		while(true) {
			panel.revalidate();
			panel.repaint();
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				break;
			}
		}
			
	}
	

}
