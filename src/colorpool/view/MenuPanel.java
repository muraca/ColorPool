package colorpool.view;

import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

import colorpool.buttons.MenuButtons;
import colorpool.config.Pictures;


public class MenuPanel extends JPanel{
	private JButton trainingButton;
	private JButton multiplayerButton;
	
	private JButton settingsButton;
	private JButton infoButton;
	private JButton recordButton;
	
	public MenuPanel(ColorPoolFrame frame) {
		
		setLayout(null); //indispensabile per il corretto posizionamento dei bottoni
		
		trainingButton = MenuButtons.trainingButton(frame, 525, 402); //TODO spazio 100 tra i bottoni
		this.add(trainingButton);

		multiplayerButton = MenuButtons.multiplayerButton(frame, 525, 502);
		this.add(multiplayerButton);
		
		settingsButton = MenuButtons.settingsButton(frame, 120, 650);
		this.add(settingsButton);
		
		infoButton = MenuButtons.infoButton(frame, 1238, 650);
		this.add(infoButton);
		
		recordButton = MenuButtons.recordButton(frame, 120, 100);
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
