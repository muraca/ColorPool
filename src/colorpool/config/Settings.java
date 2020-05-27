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
	
	static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://mooraca.dlinkddns.com/phpmyadmin/index.php";
	
    static final String DB_USER = "colorpooluser";
    static final String DB_PASS = "colorpoolpass";

	public static void throwError(int code) {
		//TODO
		System.out.println("Error " + code + ": ");
		switch (code) {
		case 2:
			System.out.println("Can't find some pictures. Please download again the game or contact the developer.");
			break;
		case 3:
			System.out.println("Can't find bitbold.ttf. Please download again the game or contact the developer.");
			break;
		case 7:
			System.out.println("Can't connect to MariaDB's website. Please check your internet connection and try again.");
			break;
		case 8:
			System.out.println("Can't connect to the records' database. Host may be down. Please check your internet connection and try again.");
			break;
		}
	}
}
