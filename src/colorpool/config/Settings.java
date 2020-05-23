package colorpool.config;

public class Settings {
	public static final int HEIGHT = 820;
	public static final int WIDTH = 1400;
	
	public static final int POOLMINX = 78;
	public static final int POOLMINY = 70;
	public static final int POOLMAXX = 1323;
	public static final int POOLMAXY = 730;
	
	public static final int BALLDIMENSION = 30;
	public static final int WHITEBALLDIMENSION = 25;
	
	public static final String START = "start";
	public static final String MENU = "menu";
	
	
	//abilita il tutorial all'inizio
	public static boolean fistTime = true;
	
	public static void initFont() {
		
	}

	public static void throwError(int code) {
		//TODO
		System.out.println("Error " + code);
		
	}
}
