package colorpool.threads;

import javax.swing.JPanel;

public class Loop implements Runnable {
	
	public JPanel panel;
	
	public Loop(JPanel panel) {
		this.panel = panel;
		
	}

	@Override
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
