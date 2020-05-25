package colorpool.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JPanel;

import colorpool.buttons.MenuButtons;


public class MenuPanel extends JPanel{
	private Image backgroundImg;
	private Image foregroundImg;
	
	private JButton trainingButton;
	
	private JButton settingsButton;
	private JButton infoButton;
	private JButton recordButton;
	
	public MenuPanel(ColorPoolFrame frame) {
        //inizializzo le immagini
		backgroundImg = frame.getPictures().getBackground();
		foregroundImg = frame.getPictures().getMenuText();
		
		setLayout(null); //indispensabile per il corretto posizionamento dei bottoni
		
		trainingButton = MenuButtons.trainingButton(frame, 525, 402); //spazio 100 tra i bottoni
		this.add(trainingButton);
		
		
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
		g.drawImage(backgroundImg, 0, 0, null);
		g.drawImage(foregroundImg, 0, 0, null);
	}
	
	private static final long serialVersionUID = 6023735830414114292L;

}
