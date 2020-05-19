package colorpool;

import colorpool.config.Settings;
import colorpool.view.*;

public class ColorPool {

	public static void main(String[] args) {
		//inizializzazione del font, accessibile a tutte le classi
		Settings.initFont();
		
		//JFrame personalizzato, per utilizzare al meglio il CardLayout
		ColorPoolFrame.getFrame().start();
		
	}
	
}
