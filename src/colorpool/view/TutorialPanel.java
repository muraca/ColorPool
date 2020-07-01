package colorpool.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import colorpool.buttons.TutorialButtons;
import colorpool.config.BitBold;
import colorpool.config.Pictures;
import colorpool.config.Settings;

public class TutorialPanel extends JPanel {

	public static final boolean ENGLISH = false;
	public static final boolean ITALIAN = true;
	
	private boolean language = ITALIAN;
	
	private JTextArea textArea;
	
	private JButton homeButton;
	private JButton languageButton;
	
	
	public TutorialPanel() {
		this.setLayout(null);
		
		initText();

		homeButton = TutorialButtons.homeButton(Settings.WIDTH-180, 100);
		this.add(homeButton);
		
		languageButton = TutorialButtons.languageButton(120, 100);
		languageButton.setIcon(new ImageIcon(Pictures.getPictures().getLanguageIcon(language)));
		this.add(languageButton);
	}

	private void initText() {
		textArea = new JTextArea("");
		textArea.setBounds(300, 200, 800, 250);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(BitBold.getFont().deriveFont(Font.BOLD, 18));
		textArea.setOpaque(false);
		textArea.setBorder(null);
    	textArea.setEditable(false);
    	textArea.setVisible(true);
    	
		this.add(textArea);
		this.revalidate();
		writeText(ENGLISH);
	}
	
	private void writeText(boolean newLanguage) {
		if(textArea.getText() == "" || language != newLanguage) {
			try {
				File f = null;
				if(newLanguage == ENGLISH) {
					f = new File(getClass().getClassLoader().getResource("resources/tutorial/english.txt").toURI());
				}
				else {
					f = new File(getClass().getClassLoader().getResource("resources/tutorial/italian.txt").toURI());
				}
				
				BufferedReader br = new BufferedReader(new FileReader(f)); 
				StringBuffer str = new StringBuffer();
				while(br.ready())
					str.append(br.readLine() + "\n");
				

				textArea.setText(str.toString());
				br.close();
				language = newLanguage;
				
			}
			catch (Exception e) {
				Settings.throwError(4);
			}
		}
	}
	
	public void changeLanguage() {
		writeText(!language);
		languageButton.setIcon(new ImageIcon(Pictures.getPictures().getLanguageIcon(language)));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Pictures.getPictures().getBackground(), 0, 0, null);
		
	}
	
	
	private static final long serialVersionUID = -7105304445031311706L;
}
