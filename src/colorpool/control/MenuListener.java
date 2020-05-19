package colorpool.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import colorpool.view.ColorPoolPanel;

public class MenuListener implements MouseListener{

	ColorPoolPanel panel;
	
	public MenuListener(ColorPoolPanel panel) {
		this.panel = panel;
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
