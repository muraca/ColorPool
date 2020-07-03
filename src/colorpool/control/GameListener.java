package colorpool.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import colorpool.config.*;
import colorpool.core.*;
import colorpool.view.*;
//visualizza i movimenti e i click del mouse durante una partita
public class GameListener implements MouseListener, MouseMotionListener {

	private GamePanel panel;
	
	public GameListener(GamePanel panel) {
		this.panel = panel;
	}
	
	//al movimento del mouse, disegna il percorso della pallina
    @Override
    public void mouseMoved(MouseEvent e) {
        if (e.getX()<=Settings.WIDTH && e.getY()<=Settings.HEIGHT && Game.getGame().ballsNotMoving()) {
            panel.setPath(new Path(e.getX(), e.getY()));
        }
        else {
            panel.setPath(null);
        }
    }

    //alla pressione del mouse, se è possibile effettua il colpo
	@Override
	public void mousePressed(MouseEvent e) {
		if(Game.getGame().ballsNotMoving()) {
			panel.setPath(null);
			Movements.shotWhiteBall(e.getX(), e.getY());
		}
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
