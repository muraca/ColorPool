package colorpool.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import colorpool.config.Settings;

public class MenuButton {
	private static Image buttonBkg = null;
	
	private static JButton menuButton(String text) {
		if(buttonBkg == null)
			buttonBkg = Toolkit.getDefaultToolkit().getImage("src/resources/menu/button.png");
		
		JButton menuButton = new JButton(text, new ImageIcon(buttonBkg));
		menuButton.setOpaque(false);
		menuButton.setBorder(BorderFactory.createEmptyBorder());
		menuButton.setForeground(Color.WHITE);
		menuButton.setFont(Settings.bitbold.deriveFont(Font.BOLD, 40f));
		menuButton.setHorizontalTextPosition(JButton.CENTER);
		menuButton.setVerticalTextPosition(JButton.CENTER);
		
		
		return menuButton;
	}
	
	
	public static JButton trainingButton(ColorPoolFrame frame) {
		JButton trainingButton = menuButton("Training");
		trainingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.stop();
				frame.training();
				
			}
		});
		return trainingButton;
	}
}
