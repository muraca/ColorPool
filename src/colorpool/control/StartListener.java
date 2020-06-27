package colorpool.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import colorpool.view.ColorPoolFrame;
//pressione di qualunque tasto o del mouse per la schermata di start
public class StartListener implements MouseListener, KeyListener {
	ColorPoolFrame frame;
	
	public StartListener(ColorPoolFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {
		frame.menu();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {  }

	@Override
	public void mouseClicked(MouseEvent e) {
		frame.menu();
		
	}

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }

}
