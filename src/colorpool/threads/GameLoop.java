package colorpool.threads;

import colorpool.core.Movements;
import colorpool.view.GamePanel;
//runnable utilizzato durante una partita
public class GameLoop implements Runnable {

	public GamePanel panel;
	
	public GameLoop(GamePanel panel) {
		this.panel=panel;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
				Movements.moveBalls();
				panel.repaint();
				Movements.movementControls();
			}
			catch (InterruptedException e) {
				break;
			}
		}
	}

}
