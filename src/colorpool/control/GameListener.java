package colorpool.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import colorpool.core.Game;
import colorpool.core.Movements;

public class GameListener implements MouseListener {
	
	Game game;
	
	GameListener(Game g){
		this.game = g;
	}

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) { 
		Movements.moveWhiteBall(game.whiteball, e.getX(), e.getY(), game.canShot);
	}

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
	
}
