package colorpool.config;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import colorpool.view.TutorialPanel;

//classe per la gestione delle immagini
public class Pictures {
	
	//sfondo del biliardo
	private Image background;
	//schermata di caricamento
	private Image start;
	private Image loading;
	
	//icona per i messaggi d'errore
	private Image errorIcon;
	
	//bottoni del menu
	private Image buttonIcon;
	private Image settingsIcon;
	private Image infoIcon;
	private Image recordIcon;
	private Image homeIcon;
	private Image menuText;
	
	//icone lingua
	private Image englishIcon;
	private Image italianIcon;
	
	//immagini del gioco
	private ArrayList<Image> balls;
	
	private static Pictures instance = null;
	
	public Pictures() {
 		balls = new ArrayList<>();
 	}
	
	public static Pictures getPictures() {
		if(instance == null)
			instance = new Pictures();
		return instance;
	}
	
	
	public Image getBall(Color c) {
		if(c==Color.WHITE) {
			return balls.get(0);
		}
		if(c==Color.RED) {
			return balls.get(1);
		}
		if(c==Color.ORANGE) {
			return balls.get(2);
		}
		if(c==Color.YELLOW) {
			return balls.get(3);
		}
		if(c==Color.GREEN) {
			return balls.get(4);
		}
		if(c==Color.CYAN) {
			return balls.get(5);
		}
		if(c==Color.BLUE) {
			return balls.get(6);
		}
		if(c==Color.MAGENTA) {
			return balls.get(7);
		}
		return null;
	}
	
	public Image getBackground() {
		return background;
	}
	
	public Image getStart() {
		return start;
	}
	
	public Image getLoading() {
		return loading;
	}
	
	public Image getErrorIcon() {
		return errorIcon;
	}
	
	public Image getButtonIcon() {
		return buttonIcon;
	}

	public Image getSettingsIcon() {
		return settingsIcon;
	}

	public Image getInfoIcon() {
		return infoIcon;
	}

	public Image getRecordIcon() {
		return recordIcon;
	}

	public Image getHomeIcon() {
		return homeIcon;
	}
	
	public Image getLanguageIcon(boolean language) {
		if(language == TutorialPanel.ENGLISH)
			return englishIcon;
		
		return italianIcon;
	}

	public Image getMenuText() {
		return menuText;
	}

	
	//caricamento delle immagini
	void loadBackground() throws IOException {
		background = ImageIO.read(getClass().getClassLoader().getResource("resources/game/pool.png"));
	}
	
	void loadStart() throws IOException {
		start = ImageIO.read(getClass().getClassLoader().getResource("resources/start/start.png"));
	}
	
	void loadLoading(int state) throws IOException {
		loading = ImageIO.read(getClass().getClassLoader().getResource("resources/start/load"+state+".png"));
	}
	
	void loadErrorIcon() throws IOException {
		errorIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/buttons/error.png"));
	}
	
	void loadButtonIcon() throws IOException {
		buttonIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/menu/button.png"));
	}
	
	void loadSettingsIcon() throws IOException {
		settingsIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/buttons/settings.png"));
	}
	
	void loadInfoIcon() throws IOException {
		infoIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/buttons/info.png"));
	}
	
	void loadRecordIcon() throws IOException {
		recordIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/buttons/record.png"));
	}
	
	void loadHomeIcon() throws IOException {
		homeIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/buttons/home.png"));
	}
	
	void loadLanguageIcons() throws IOException {
		englishIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/buttons/english.png"));
		italianIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/buttons/italian.png"));
	}
	
	void loadMenuText() throws IOException {
		menuText = ImageIO.read(getClass().getClassLoader().getResource("resources/menu/text.png"));
	}

	public void loadBalls() throws IOException{
		balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/whiteball.png"))); 
		balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/redball.png"))); 
		balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/orangeball.png"))); 
		balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/yellowball.png"))); 
		balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/greenball.png"))); 
		balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/cyanball.png"))); 
		balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/blueball.png"))); 
		balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/purpleball.png"))); 
	}

	
	
}
