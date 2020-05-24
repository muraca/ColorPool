package colorpool.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MenuPanel extends JPanel{
	private Image backgroundImg;
	private Image foregroundImg;
	
	private JButton trainingButton;
	
	private JButton settingsButton;
	private JButton infoButton;
	private JButton recordButton;
	
	public MenuPanel(ColorPoolFrame frame) {
        //inizializzo le immagini
		backgroundImg = Toolkit.getDefaultToolkit().getImage("src/resources/background/pool.png");
		foregroundImg = Toolkit.getDefaultToolkit().getImage("src/resources/menu/text.png");
		
		setLayout(null); //indispensabile per il corretto posizionamento dei bottoni
		
		trainingButton = MenuButton.trainingButton(frame, 525, 402); //spazio 100 tra i bottoni
		this.add(trainingButton);
		
		
		settingsButton = MenuButton.settingsButton(frame, 120, 650);
		this.add(settingsButton);
		
		infoButton = MenuButton.infoButton(frame, 1238, 650);
		this.add(infoButton);
		
		recordButton = MenuButton.recordButton(frame, 120, 100);
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
