package colorpool.config;

import java.awt.Color;
import colorpool.view.ColorPoolFrame;
import colorpool.view.MyOptionPane;

//impostazioni generali del gioco, inizializzazione, gestione delle eccezioni
public class Settings {
	public static final int HEIGHT = 820;
	public static final int WIDTH = 1400;
	
	public static final int POOLMINX = 78;
	public static final int POOLMINY = 70;
	public static final int POOLMAXX = 1323;
	public static final int POOLMAXY = 730;
	
	public static final int BALLDIMENSION = 30;
	public static final int WHITEBALLDIMENSION = 25;
	
	public static Color player1color = Color.BLUE;
	public static Color player2color = Color.RED;
	public static Color singleplayercolor = Color.WHITE;
	

    public static void init(){
    	
    	try {
			Pictures.getPictures().loadBackground();
			ColorPoolFrame.getFrame().getStartPanel().setBackground(Pictures.getPictures().getBackground());
			
			Pictures.getPictures().loadStart();
			ColorPoolFrame.getFrame().getStartPanel().setForeground(Pictures.getPictures().getStart());
			
			Pictures.getPictures().loadLoading(0);
			ColorPoolFrame.getFrame().getStartPanel().setLoadingImg(Pictures.getPictures().getLoading());
			
			Pictures.getPictures().loadButtonIcon();
			Pictures.getPictures().loadSettingsIcon(); 
			Pictures.getPictures().loadInfoIcon(); 
			
			Pictures.getPictures().loadLoading(1);
			ColorPoolFrame.getFrame().getStartPanel().setLoadingImg(Pictures.getPictures().getLoading());
			Thread.sleep(500);
			
			Pictures.getPictures().loadRecordIcon(); 
			Pictures.getPictures().loadHomeIcon(); 
			
			Pictures.getPictures().loadLoading(2);
			ColorPoolFrame.getFrame().getStartPanel().setLoadingImg(Pictures.getPictures().getLoading());
			Thread.sleep(500);		

			Pictures.getPictures().loadMenuText(); 
			Pictures.getPictures().loadStick(); 
			
			Pictures.getPictures().loadLoading(3);
			ColorPoolFrame.getFrame().getStartPanel().setLoadingImg(Pictures.getPictures().getLoading());
			Thread.sleep(800);
			
			Pictures.getPictures().loadBalls();
			BitBold.initFont();
			
			Pictures.getPictures().loadLoading(4);
			ColorPoolFrame.getFrame().getStartPanel().setLoadingImg(Pictures.getPictures().getLoading());
			Thread.sleep(500);
			
		}
		catch (Exception e) {
			Settings.throwError(2);
		}	
    	
    	ColorPoolFrame.getFrame().getStartPanel().completed();
    }
    
	public static void throwError(int code) {
		String text;
		switch (code) {
		case 1:
			text = "Work in progress...";
			break;
		case 2:
			text = "Can't find some pictures. Please download again the game or contact the developer.";
			break;
		case 3:
			text = "Can't find bitbold.ttf. Please download again the game or contact the developer.";
			break;
		default:
			text = "Undefined error. Please try again.";
			break;
		}
		MyOptionPane.errorPane(code, text);
		
	}
}
