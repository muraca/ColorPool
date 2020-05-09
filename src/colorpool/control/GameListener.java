package colorpool.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import colorpool.config.*;
import colorpool.core.*;
import colorpool.view.*;

public class GameListener implements MouseListener, MouseMotionListener {

	private GamePanel panel;
	
	public GameListener(GamePanel panel) {
		this.panel = panel;
	}
	
    @Override
    public void mouseMoved(MouseEvent e) {
        if (e.getX()<=Settings.WIDTH && e.getY()<=Settings.HEIGHT && Game.getGame().canShot())
            panel.p = new Pointer(e.getX(), e.getY());
        else
            panel.p = null;
    }

	@Override
	public void mousePressed(MouseEvent e) {
		if(Game.getGame().canShot()) {
			panel.p = null;
			Movements.shotWhiteBall(e.getX(), e.getY());
		}
		panel.repaint();
	}
    
    @Override
    public void mouseClicked(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
	
    @Override
    public void mouseDragged(MouseEvent e) {}
}
