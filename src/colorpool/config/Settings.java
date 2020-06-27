package colorpool.config;

import java.io.IOException;

import colorpool.view.ColorPoolFrame;

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
	
	public static final String START = "start";
	public static final String MENU = "menu";
	

    public static void init() throws InterruptedException {
    	
    		try {
    			Pictures.getPictures().loadBackground();
    			ColorPoolFrame.getFrame().getStart().setBackground(Pictures.getPictures().getBackground());
    			
    			Pictures.getPictures().loadStart();
    			ColorPoolFrame.getFrame().getStart().setForeground(Pictures.getPictures().getStart());
    			
    			Pictures.getPictures().loadLoading(0);
    			ColorPoolFrame.getFrame().getStart().setLoadingImg(Pictures.getPictures().getLoading());
    			
    			Pictures.getPictures().loadButtonIcon();
    			Pictures.getPictures().loadSettingsIcon(); 
    			Pictures.getPictures().loadInfoIcon(); 
    			
    			Pictures.getPictures().loadLoading(1);
    			ColorPoolFrame.getFrame().getStart().setLoadingImg(Pictures.getPictures().getLoading());
    			ColorPoolFrame.getFrame().getStart().repaint();
    			Thread.sleep(500);
    			
    			Pictures.getPictures().loadRecordIcon(); 
    			Pictures.getPictures().loadHomeIcon(); 
    			
    			Pictures.getPictures().loadLoading(2);
    			ColorPoolFrame.getFrame().getStart().setLoadingImg(Pictures.getPictures().getLoading());
    			Thread.sleep(500);		

    			Pictures.getPictures().loadMenuText(); 
    			Pictures.getPictures().loadStick(); 

    			Pictures.getPictures().loadLoading(3);
    			ColorPoolFrame.getFrame().getStart().setLoadingImg(Pictures.getPictures().getLoading());
    			Thread.sleep(800);
    			
    			Pictures.getPictures().loadBalls();
    			BitBold.initFont();
    			
    			Pictures.getPictures().loadLoading(4);
    			ColorPoolFrame.getFrame().getStart().setLoadingImg(Pictures.getPictures().getLoading());
    			Thread.sleep(500);
    			
    		}
    		catch (IOException e) {
    			Settings.throwError(2);
    		} catch (InterruptedException e) { }
    		
    	Thread.sleep(500);
    	
    	ColorPoolFrame.getFrame().getStart().completed();
    }
    
	public static void throwError(int code) {
		//TODO
		System.out.println("Error " + code + ": ");
		switch (code) {
		case 1:
			System.out.println("Work in progress...");
			break;
		case 2:
			System.out.println("Can't find some pictures. Please download again the game or contact the developer.");
			break;
		case 3:
			System.out.println("Can't find bitbold.ttf. Please download again the game or contact the developer.");
			break;
		}
	}
}
