package colorpool.config;

import java.awt.Font;
import java.io.File;

public class BitBold {

	public static BitBold instance;

	private Font bitbold;
	
	public BitBold() {
		try {
			bitbold = Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getClassLoader().getResource("resources/fonts/bitbold.ttf").toURI()));
			
		} catch (Exception e) {
			Settings.throwError(3);
		} 
	}
	
	
	public static Font getFont() {
		if(instance == null)
			instance = new BitBold();
		return instance.bitbold;
	}
}
