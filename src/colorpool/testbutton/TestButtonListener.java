package colorpool.testbutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import colorpool.core.*;

//listener per il bottone di test
public class TestButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Movements.stopBalls();
		Game.getGame().pot(Game.getGame().getWhiteBall());
		
	}

}
