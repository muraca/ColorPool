package colorpool.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import colorpool.view.ColorPoolFrame;

public class StartListener implements MouseListener, KeyListener {
	ColorPoolFrame frame;
	
	public StartListener(ColorPoolFrame frame) {
		this.frame = frame;
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
		frame.menu();
	}

}
