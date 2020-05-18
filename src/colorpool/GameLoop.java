package colorpool;

import colorpool.core.Movements;
import colorpool.view.GamePanel;

public class GameLoop implements Runnable {

	public GamePanel panel;
	
	public GameLoop(GamePanel panel) {
		this.panel=panel;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
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
