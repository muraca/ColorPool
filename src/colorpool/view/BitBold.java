package colorpool.view;

import java.awt.Font;
import java.io.File;

import colorpool.config.Settings;

public class BitBold {

	public static BitBold instance;

	private Font bitbold;
	
	public BitBold() {
		try {
			bitbold = Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getClassLoader().getResource("resources/fonts/bitbold.ttf").toURI()));
			
		} catch (Exception e) {
			Settings.throwError(4);
		} 
	}
	
	public static void initFont() {
		if(instance == null)
			instance = new BitBold();
	}
	
	public static Font getFont() {
		initFont();
		return instance.bitbold;
	}
}
