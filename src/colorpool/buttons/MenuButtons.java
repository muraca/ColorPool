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
import colorpool.core.Game;
import colorpool.view.ColorPoolFrame;

//bottoni per il menu
public class MenuButtons {
	//template per i bottoni principali
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
	
	//avvia una partita
	public static JButton playButton(int x, int y, boolean gamemode) {
		String message;
		if(gamemode == Game.SINGLEPLAYER)
			message = "1 Player";
		else
			message = "2 Players";
		JButton trainingButton = menuButton(message);
		trainingButton.setBounds(x, y, 350, 62);
		trainingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ColorPoolFrame.getFrame().game(gamemode);
			}
		});
		return trainingButton;
	}
	
	
	//impostazioni
	public static JButton settingsButton(int x, int y) {
		JButton settingsButton = new JButton(new ImageIcon(Pictures.getPictures().getSettingsIcon()));
		settingsButton.setBounds(x, y, 42, 42);
		settingsButton.setOpaque(false);
		settingsButton.setBorder(BorderFactory.createEmptyBorder());
		settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ColorPoolFrame.getFrame().settings();
			}
		});
		return settingsButton;
	}
	
	//informazioni sul gioco
	public static JButton infoButton(int x, int y) {
		JButton infoButton = new JButton(new ImageIcon(Pictures.getPictures().getInfoIcon()));
		infoButton.setBounds(x, y, 42, 42);
		infoButton.setOpaque(false);
		infoButton.setBorder(BorderFactory.createEmptyBorder());
		infoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ColorPoolFrame.getFrame().info();
			}
		});
		return infoButton;
		
	}

	//visualizzare i record
	public static JButton recordButton(int x, int y) {
		JButton recordButton = new JButton(new ImageIcon(Pictures.getPictures().getRecordIcon()));
		recordButton.setBounds(x, y, 42, 42);
		recordButton.setOpaque(false);
		recordButton.setBorder(BorderFactory.createEmptyBorder());
		recordButton.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				ColorPoolFrame.getFrame().record();
			}
		});
		return recordButton;
	}

	
}
