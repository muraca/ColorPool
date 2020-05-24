package colorpool.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import colorpool.core.Game;
import colorpool.view.ColorPoolFrame;

public class GameButtons {

	public static JButton homeButton(ColorPoolFrame frame, int x, int y) {
		JButton homeButton = new JButton(new ImageIcon(ColorPoolFrame.getFrame().getPictures().getHomeIcon()));
		homeButton.setBounds(x, y, 42, 42);
		homeButton.setOpaque(false);
		homeButton.setBorder(BorderFactory.createEmptyBorder());
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.home();
			}
		});
		return homeButton;
		
	}
	
}
