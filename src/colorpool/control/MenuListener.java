package colorpool.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import colorpool.view.ColorPoolFrame;

public class MenuListener implements MouseListener{

	ColorPoolFrame frame;
	
	public MenuListener(ColorPoolFrame frame) {
		this.frame = frame;
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse pressed in menu");
		
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

}
