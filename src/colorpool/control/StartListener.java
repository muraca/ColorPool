package colorpool.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import colorpool.threads.MenuLoop;
import colorpool.view.ColorPoolPanel;

public class StartListener implements MouseListener, KeyListener {
	ColorPoolPanel panel;
	
	public StartListener(ColorPoolPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		action();
	}

	@Override
	public void keyPressed(KeyEvent e) { }

	@Override
	public void keyReleased(KeyEvent e) { }

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) {
		action();
	}

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
	
	private void action() {
		panel.layout.show(panel, "menu");
		panel.thread = new Thread(new MenuLoop(panel.getMenu()));
		panel.run();
		
	}

}
