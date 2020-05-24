package colorpool.view;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import colorpool.config.Settings;

public class Pictures {
	//balls
	private ArrayList<Image> balls;
	//pool background
	private Image background;
	//start menu
	private Image start;
	private Image loading;
	
	//menu icons
	private Image buttonIcon;
	private Image settingsIcon;
	private Image infoIcon;
	private Image recordIcon;
	private Image homeIcon;
	

	public Pictures() {
 		balls = new ArrayList<>();
 	}
	
	public void initPictures() {
		try {
			background = ImageIO.read(getClass().getClassLoader().getResource("resources/background/pool.png"));
			ColorPoolFrame.getFrame().getStart().setBackground(background);
			
			start = ImageIO.read(getClass().getClassLoader().getResource("resources/start/start.png"));
			ColorPoolFrame.getFrame().getStart().setForeground(start);
			
			loading = ImageIO.read(getClass().getClassLoader().getResource("resources/start/load0.png"));
			ColorPoolFrame.getFrame().getStart().setLoadingImg(loading);
			ColorPoolFrame.getFrame().getStart().repaint();
			Thread.sleep(500);
			
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/whiteball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/redball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/orangeball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/yellowball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/greenball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/cyanball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/blueball.png"))); 
			balls.add(ImageIO.read(getClass().getClassLoader().getResource("resources/balls/purpleball.png"))); 
			
			loading = ImageIO.read(getClass().getClassLoader().getResource("resources/start/load1.png"));
			ColorPoolFrame.getFrame().getStart().setLoadingImg(loading);
			ColorPoolFrame.getFrame().getStart().repaint();
			Thread.sleep(500);
			
			
			buttonIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/menu/button.png"));
			settingsIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/buttons/settings.png"));
			infoIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/buttons/info.png"));
			
			loading = ImageIO.read(getClass().getClassLoader().getResource("resources/start/load2.png"));
			ColorPoolFrame.getFrame().getStart().setLoadingImg(loading);
			ColorPoolFrame.getFrame().getStart().repaint();
			Thread.sleep(500);
			
			//other stuff
			recordIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/buttons/record.png"));
			homeIcon = ImageIO.read(getClass().getClassLoader().getResource("resources/buttons/home.png"));
			
			
			loading = ImageIO.read(getClass().getClassLoader().getResource("resources/start/load3.png"));
			ColorPoolFrame.getFrame().getStart().setLoadingImg(loading);
			ColorPoolFrame.getFrame().getStart().repaint();
			Thread.sleep(800);
			
			//maybe other stuff
			
			loading = ImageIO.read(getClass().getClassLoader().getResource("resources/start/load4.png"));
			ColorPoolFrame.getFrame().getStart().setLoadingImg(loading);
			ColorPoolFrame.getFrame().getStart().repaint();
			Thread.sleep(500);
		
			}
		catch (IOException e) {
			Settings.throwError(4);
		} catch (InterruptedException e) { }
		
		ColorPoolFrame.getFrame().getStart().completed();
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
}
