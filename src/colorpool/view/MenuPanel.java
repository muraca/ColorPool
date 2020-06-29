package colorpool.view;

import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

import colorpool.buttons.MenuButtons;
import colorpool.config.Pictures;
import colorpool.core.Game;


public class MenuPanel extends JPanel{
	private JButton trainingButton;
	private JButton multiplayerButton;
	
	private JButton settingsButton;
	private JButton infoButton;
	private JButton recordButton;
	
	public MenuPanel() {
		
		setLayout(null); //indispensabile per il corretto posizionamento dei bottoni
		
		trainingButton = MenuButtons.playButton(525, 402, Game.SINGLEPLAYER);
		this.add(trainingButton);

		multiplayerButton = MenuButtons.playButton(525, 502, Game.MULTIPLAYER);
		this.add(multiplayerButton);
		
		settingsButton = MenuButtons.settingsButton(120, 650);
		this.add(settingsButton);
		
		infoButton = MenuButtons.infoButton(1238, 650);
		this.add(infoButton);
		
		recordButton = MenuButtons.recordButton(120, 100);
		this.add(recordButton);
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Pictures.getPictures().getBackground(), 0, 0, null);
		g.drawImage(Pictures.getPictures().getMenuText(), 0, 0, null);
	}
	
	private static final long serialVersionUID = 6023735830414114292L;

}
