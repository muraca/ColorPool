package colorpool.config;

import java.awt.Font;
import java.io.File;

public class Settings {
	public static final int HEIGHT = 800;//800;
	public static final int WIDTH = 1400;
	
	public static final int POOLMINX = 78;
	public static final int POOLMINY = 70;
	public static final int POOLMAXX = 1323;
	public static final int POOLMAXY = 730;
	
	public static final int BALLDIMENSION = 30;
	public static final int WHITEBALLDIMENSION = 25;
	
	public static final String START = "start";
	public static final String MENU = "menu";
	public static Font bitbold;
	
	
	//abilita il tutorial all'inizio
	public static boolean fistTime = true;
	
	public static void initFont() {
		try {
			bitbold = Font.createFont(Font.TRUETYPE_FONT,new File("src/resources/fonts/bitbold.ttf"));
			
		} catch (Exception e) { } 
	}
}
