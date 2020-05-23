package colorpool.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import colorpool.config.Settings;

public class MenuButton {
	//private static Image langIcon = null;
	private static JButton menuButton(String text) {
		
		JButton menuButton = new JButton(text, new ImageIcon(Pictures.getInstance().getButtonIcon()));
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
		JButton settingsButton = new JButton(new ImageIcon(Pictures.getInstance().getSettingsIcon()));
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
		JButton infoButton = new JButton(new ImageIcon(Pictures.getInstance().getInfoIcon()));
		infoButton.setBounds(x, y, 42, 42);
		infoButton.setOpaque(false);
		infoButton.setBorder(BorderFactory.createEmptyBorder());
		infoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String infoMessage = "©2020 Matteo Muraca, made for IGPE Course";
				JOptionPane.showMessageDialog(null, infoMessage, "Info", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Pictures.getInstance().getInfoIcon()));
			}
		});
		return infoButton;
		
	}
}
