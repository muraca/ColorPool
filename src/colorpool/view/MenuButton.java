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
import javax.swing.JOptionPane;

import colorpool.config.Settings;

public class MenuButton {
	private static Image buttonIcon = null;
	private static Image settingsIcon = null;
	private static Image infoIcon = null;
	//private static Image langIcon = null;
	private static JButton menuButton(String text) {
		if(buttonIcon == null)
			buttonIcon = Toolkit.getDefaultToolkit().getImage("src/resources/menu/button.png");
		
		JButton menuButton = new JButton(text, new ImageIcon(buttonIcon));
		menuButton.setOpaque(false);
		menuButton.setBorder(BorderFactory.createEmptyBorder());
		menuButton.setForeground(Color.WHITE);
		menuButton.setFont(Settings.bitbold.deriveFont(Font.BOLD, 40f));
		menuButton.setHorizontalTextPosition(JButton.CENTER);
		menuButton.setVerticalTextPosition(JButton.CENTER);
		
		return menuButton;
	}
	
	
	public static JButton trainingButton(ColorPoolFrame frame, int x, int y) {
		JButton trainingButton = menuButton("Training");
		trainingButton.setBounds(x, y, 350, 62);
		trainingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.training();
			}
		});
		return trainingButton;
	}
	
	
	
	public static JButton settingsButton(ColorPoolFrame frame, int x, int y) {
		if(settingsIcon == null)
			settingsIcon = Toolkit.getDefaultToolkit().getImage("src/resources/menu/settings.png");
		JButton settingsButton = new JButton(new ImageIcon(settingsIcon));
		settingsButton.setBounds(x, y, 42, 42);
		settingsButton.setOpaque(false);
		settingsButton.setBorder(BorderFactory.createEmptyBorder());
		settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.settings();
			}
		});
		return settingsButton;
	}
	
	public static JButton infoButton(int x, int y) {
		if(infoIcon == null)
			infoIcon = Toolkit.getDefaultToolkit().getImage("src/resources/menu/info.png");
		JButton infoButton = new JButton(new ImageIcon(infoIcon));
		infoButton.setBounds(x, y, 42, 42);
		infoButton.setOpaque(false);
		infoButton.setBorder(BorderFactory.createEmptyBorder());
		infoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String infoMessage = "Color Pool ©2020 Matteo Muraca, made for IGPE Course";
				JOptionPane.showMessageDialog(null, infoMessage, "Info", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(infoIcon));
			}
		});
		return infoButton;
		
	}
}
