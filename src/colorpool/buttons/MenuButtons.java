package colorpool.buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import colorpool.config.BitBold;
import colorpool.config.Pictures;
import colorpool.view.ColorPoolFrame;

public class MenuButtons {
	
	private static JButton menuButton(String text) {
		
		JButton menuButton = new JButton(text, new ImageIcon(Pictures.getPictures().getButtonIcon()));
		menuButton.setOpaque(false);
		menuButton.setBorder(BorderFactory.createEmptyBorder());
		menuButton.setForeground(Color.WHITE);
		menuButton.setFont(BitBold.getFont().deriveFont(Font.BOLD, 40f));
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
		JButton settingsButton = new JButton(new ImageIcon(Pictures.getPictures().getSettingsIcon()));
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
	
	public static JButton infoButton(ColorPoolFrame frame, int x, int y) {
		JButton infoButton = new JButton(new ImageIcon(Pictures.getPictures().getInfoIcon()));
		infoButton.setBounds(x, y, 42, 42);
		infoButton.setOpaque(false);
		infoButton.setBorder(BorderFactory.createEmptyBorder());
		infoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.info();
			}
		});
		return infoButton;
		
	}


	public static JButton recordButton(ColorPoolFrame frame, int x, int y) {
		JButton recordButton = new JButton(new ImageIcon(Pictures.getPictures().getRecordIcon()));
		recordButton.setBounds(x, y, 42, 42);
		recordButton.setOpaque(false);
		recordButton.setBorder(BorderFactory.createEmptyBorder());
		recordButton.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.record();
			}
		});
		return recordButton;
	}
}
