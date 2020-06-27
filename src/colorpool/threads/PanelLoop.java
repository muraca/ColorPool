package colorpool.threads;

import javax.swing.JPanel;

//runnable utilizzato nei vari pannelli
public class PanelLoop implements Runnable {
	
	public JPanel panel;
	
	public PanelLoop(JPanel panel) {
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
