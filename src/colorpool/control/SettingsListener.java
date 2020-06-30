package colorpool.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import colorpool.view.MyColorPicker;
import colorpool.view.SettingsDialog;

public class SettingsListener implements MouseListener {

	private int type;
	
	public SettingsListener(int type) {
		this.type = type;
	}

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) {
		SettingsDialog.close();
		MyColorPicker.pick(type);
		SettingsDialog.renew();
	}

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
	
}
