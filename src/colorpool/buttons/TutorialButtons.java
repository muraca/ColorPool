package colorpool.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import colorpool.config.Pictures;
import colorpool.view.ColorPoolFrame;
//bottoni utilizzati nel menu tutorial
public class TutorialButtons {
	//bottone per tornare alla home
	public static JButton homeButton(int x, int y) {
		JButton homeButton = new JButton(new ImageIcon(Pictures.getPictures().getHomeIcon()));
		homeButton.setBounds(x, y, 42, 42);
		homeButton.setOpaque(false);
		homeButton.setBorder(BorderFactory.createEmptyBorder());
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ColorPoolFrame.getFrame().menu();
			}
		});
		return homeButton;
		
	}
	//bottone di cambio lingua
	public static JButton languageButton(int x, int y) {
		JButton languageButton = new JButton();
		languageButton.setBounds(x, y, 42, 42);
		languageButton.setOpaque(false);
		languageButton.setBorder(BorderFactory.createEmptyBorder());
		languageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ColorPoolFrame.getFrame().getTutorialPanel().changeLanguage();
			}
		});
		return languageButton;
		
	}
}
