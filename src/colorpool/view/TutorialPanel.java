package colorpool.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import colorpool.buttons.TutorialButtons;
import colorpool.config.BitBold;
import colorpool.config.Pictures;
import colorpool.config.Settings;

public class TutorialPanel extends JPanel {

	public static final boolean ENGLISH = false;
	public static final boolean ITALIAN = true;
	
	private boolean language = ITALIAN;
	
	private JTextField textArea;
	private String text;
	
	private JButton homeButton;
	private JButton languageButton;
	
	
	public TutorialPanel() {
		super();
		setLayout(null);
		
		homeButton = TutorialButtons.homeButton(Settings.WIDTH-180, 100);
		this.add(homeButton);
		
		languageButton = TutorialButtons.languageButton(120, 100);
		languageButton.setIcon(new ImageIcon(Pictures.getPictures().getLanguageIcon(language)));
		this.add(languageButton);
		
		initText();
	}

	private void initText() {
		textArea = new JTextField("");
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.RED);
		textArea.setFont(BitBold.getFont().deriveFont(Font.BOLD, 25f));
		textArea.setOpaque(false);
		textArea.setBorder(BorderFactory.createLineBorder(Color.CYAN, 10));
    	textArea.setEditable(true);
    	textArea.setBounds(Settings.POOLMINX, Settings.POOLMINX, Settings.WIDTH-Settings.POOLMAXX, Settings.HEIGHT-Settings.POOLMAXX);
    	textArea.setVisible(true);
    	
		this.add(textArea);
		writeText(language);
	}
	
	private void writeText(boolean newLanguage) {
		if(textArea.getText() == null || language != newLanguage) {
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
					str.append(br.readLine());
				
				
				text = str.toString();
				br.close();
				language = newLanguage;
				
			}
			catch (Exception e) {
				Settings.throwError(4);
			}
		}
		text = "ciao Andrea come va la vita a Milano";
		textArea.setText(text);
	}
	
	public void changeLanguage() {
		writeText(!language);
		languageButton.setIcon(new ImageIcon(Pictures.getPictures().getLanguageIcon(language)));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Pictures.getPictures().getBackground(), 0, 0, null);
		writeText(language);
	}
	
	
	private static final long serialVersionUID = -7105304445031311706L;
}
