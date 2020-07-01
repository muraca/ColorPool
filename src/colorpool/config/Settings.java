package colorpool.config;

import java.awt.Color;
import colorpool.view.ColorPoolFrame;
import colorpool.view.MyOptionPane;

//impostazioni generali del gioco, inizializzazione, gestione delle eccezioni
public class Settings {
	//dimensioni della finestra
	public static final int HEIGHT = 820;
	public static final int WIDTH = 1400;
	
	//punti che delimitano l'area giocabile del biliardo
	public static final int POOLMINX = 78;
	public static final int POOLMINY = 70;
	public static final int POOLMAXX = 1323;
	public static final int POOLMAXY = 730;
	
	public static final int BALLDIMENSION = 30; //dimensione delle palline colorate
	public static final int WHITEBALLDIMENSION = 25; //dimensione della pallina bianca
	
	public static final boolean DEBUGGING = false; //controlla la comparsa del testbutton nel gioco
	
	public static final Color BACKGROUNDCOLOR = new Color(0, 105, 48); //colore di sfondo per i vari pannelli
	
	//colori di default per i giocatori, possono essere modificati nelle impostazioni
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

			Pictures.getPictures().loadLanguageIcons();
			Pictures.getPictures().loadMenuText(); 
			
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
		default:
			text = "Undefined error. Please try again.";
			break;
		}
		MyOptionPane.errorPane(code, text);
		
	}
}
