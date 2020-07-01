package colorpool.config;

import java.awt.Font;
import java.io.File;

public class BitBold {

	public static BitBold instance = null;

	private Font bitbold;
	
	public BitBold() {
		try {
			bitbold = Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getClassLoader().getResource("resources/fonts/bitbold.ttf").toURI()));
			
		} catch (Exception e) {
			
			substituteFont();
		} 
	}
	
	static void initFont() {
		instance = new BitBold();
	}
	
	private void substituteFont() {
		bitbold = new Font("Arial", Font.BOLD, 14);
	}
	
	public static Font getFont() {
		if(instance == null)
			instance = new BitBold();
		return instance.bitbold;
	}
}
