package colorpool.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import colorpool.view.ColorPoolFrame;

public class MenuListener implements ActionListener{

	ColorPoolFrame frame;
	
	public MenuListener(ColorPoolFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.stop();
		frame.training();
		
	}

	

	

}
