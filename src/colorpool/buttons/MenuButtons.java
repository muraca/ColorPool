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
	
	//modalità d'allenamento
	public static JButton trainingButton(ColorPoolFrame frame, int x, int y) {
		JButton trainingButton = menuButton("1 Player");
		trainingButton.setBounds(x, y, 350, 62);
		trainingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.training();
			}
		});
		return trainingButton;
	}
	
	public static JButton multiplayerButton(ColorPoolFrame frame, int x, int y) {
		JButton multiplayerButton = menuButton("2 Players");
		multiplayerButton.setBounds(x, y, 350, 62);
		multiplayerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.multiplayer();
			}
		});
		return multiplayerButton;
	}
	
	//impostazioni
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
	
	//informazioni sul gioco
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

	//visualizzare i record
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
