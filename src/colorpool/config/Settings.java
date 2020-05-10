package colorpool.config;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Settings 
{
	//DIMENSIONE MASSIMA PER OGNI SCHERMO
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int HEIGHT = (int)screenSize.getHeight();//800;
	public static final int WIDTH = (int) screenSize.getWidth();
	
	public static final int POOLMINX = 78;
	public static final int POOLMINY = 70;
	public static final int POOLMAXX = 1323;
	public static final int POOLMAXY = 730;
	
	public static final int BALLDIMENSION = 30;
	public static final int WHITEBALLDIMENSION = 25;
	public static final int POTDIMENSION = 40;
	
	public static final Color POOLCOLOR = new Color(23, 127, 26);
	//abilita il tutorial all'inizio
	public static boolean fistTime = true;
}
