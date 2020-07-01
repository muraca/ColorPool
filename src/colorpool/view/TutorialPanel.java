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
import javax.swing.JTextField;

import colorpool.buttons.TutorialButtons;
import colorpool.config.BitBold;
import colorpool.config.Pictures;
import colorpool.config.Settings;

public class TutorialPanel extends JPanel {

	public static final boolean ENGLISH = false;
	public static final boolean ITALIAN = true;
	
	private boolean language = ITALIAN;
	
	private JTextField textField;
	private String text;
	
	private JButton homeButton;
	private JButton languageButton;
	
	
	public TutorialPanel() {
		super();
		this.setLayout(null);
		
		homeButton = TutorialButtons.homeButton(Settings.WIDTH-180, 100);
		this.add(homeButton);
		
		languageButton = TutorialButtons.languageButton(120, 100);
		languageButton.setIcon(new ImageIcon(Pictures.getPictures().getLanguageIcon(language)));
		this.add(languageButton);
		
		initText();
	}

	private void initText() {
		textField = new JTextField("");
		textField.setBounds(Settings.POOLMINX, Settings.POOLMINX, Settings.WIDTH-Settings.POOLMAXX, Settings.HEIGHT-Settings.POOLMAXX);
		textField.setForeground(Color.WHITE);
		textField.setFont(BitBold.getFont().deriveFont(Font.BOLD, 25));
		textField.setBackground(Color.YELLOW);
		textField.setOpaque(true);
		textField.setBorder(BorderFactory.createLineBorder(Color.RED, 22));
    	textField.setEditable(true);
    	textField.setVisible(true);
    	
		this.add(textField);
		writeText(language);
	}
	
	private void writeText(boolean newLanguage) {
		if(textField.getText() == null || language != newLanguage) {
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
		textField.setText(text);
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
