package colorpool;

import colorpool.core.*;
import colorpool.view.*;

public class ThreadAnimations extends Thread {
	private GamePanel panel;
	
	public ThreadAnimations(GamePanel panel) {
		this.panel=panel;
	}
	
	@Override
	public void run() {
		super.run();
		//animazioni
		while(true) {
			try {
				Thread.sleep(10);
				Movements.moveBalls();
				panel.repaint();
			}
			catch (InterruptedException e) {
				break;
			}
		}
	}
	
}
