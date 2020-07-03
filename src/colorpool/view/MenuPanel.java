package colorpool.view;

import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

import colorpool.buttons.MenuButtons;
import colorpool.config.Pictures;
import colorpool.config.Settings;
import colorpool.core.Game;
//rappresenta il menu principale
public class MenuPanel extends JPanel{
	private JButton trainingButton;
	private JButton multiplayerButton;
	private JButton tutorialButton;
	
	private JButton settingsButton;
	private JButton infoButton;
	private JButton recordButton;
	
	public MenuPanel() {
		
		setLayout(null); //indispensabile per il corretto posizionamento dei bottoni
		
		//singleplayer
		trainingButton = MenuButtons.playButton(525, 402, Game.SINGLEPLAYER);
		this.add(trainingButton);
		
		//multiplayer
		multiplayerButton = MenuButtons.playButton(525, 502, Game.MULTIPLAYER);
		this.add(multiplayerButton);
		
		//tutorial
		tutorialButton = MenuButtons.tutorialButton(525, 602);
		this.add(tutorialButton);
		
		//impostazioni
		settingsButton = MenuButtons.settingsButton(120, 650);
		this.add(settingsButton);
		
		//informazioni
		infoButton = MenuButtons.infoButton(1238, 650);
		this.add(infoButton);
		
		//record
		if(Settings.RECORD) {
			recordButton = MenuButtons.recordButton(120, 100);
			this.add(recordButton);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Pictures.getPictures().getBackground(), 0, 0, null);
		g.drawImage(Pictures.getPictures().getMenuText(), 0, 0, null);
	}
	
	private static final long serialVersionUID = 6023735830414114292L;

}
