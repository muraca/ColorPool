package colorpool.threads;

import colorpool.view.StartPanel;

public class StartLoop implements Runnable {
	
	public StartPanel panel;
	
	public StartLoop(StartPanel panel) {
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
