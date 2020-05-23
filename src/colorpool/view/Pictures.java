package colorpool.view;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import colorpool.config.Settings;

public class Pictures {
	private ArrayList<Image> balls;
	
	//menu icons
	private Image buttonIcon = null;
	private Image settingsIcon = null;
	private Image infoIcon = null;
	
 	public static Pictures instance = null;
 	
 	public Pictures() {
 		initPictures();
 	}
	
	public void initPictures() {
		balls = new ArrayList<>();
		
		
		try {
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/whiteball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/redball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/orangeball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/yellowball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/greenball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/cyanball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/blueball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/purpleball.png"))); 
			
			buttonIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/menu/button.png"));
			settingsIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/menu/settings.png"));
			infoIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/menu/info.png"));
			}
			catch (IOException e) {
				Settings.throwError(4);
			}
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
	
	public Image getButtonIcon() {
		return buttonIcon;
	}

	public Image getSettingsIcon() {
		return settingsIcon;
	}

	public Image getInfoIcon() {
		return infoIcon;
	}

	public static Pictures getInstance() {
		if(instance==null)
			instance = new Pictures();
		return instance;
	}
}
