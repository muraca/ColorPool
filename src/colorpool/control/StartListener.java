package colorpool.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import colorpool.view.ColorPoolPanel;

public class StartListener implements MouseListener, KeyListener {
	ColorPoolPanel panel;
	
	public StartListener(ColorPoolPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {
		action();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {  }

	@Override
	public void mouseClicked(MouseEvent e) {
		action();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void action() {
		panel.stop();
		panel.menu();
	}

}
