package colorpool.view;


import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import colorpool.config.Settings;
import colorpool.core.Game;
import colorpool.testbutton.*;
import colorpool.threads.GameLoop;
import colorpool.threads.PanelLoop;
//JFrame personalizzato, per utilizzare al meglio il CardLayout
public class ColorPoolFrame extends JFrame {
	private CardLayout layout;
	private Container container;
	private StartPanel startP;
	private MenuPanel menuP;
	private GamePanel gameP;
	private TutorialPanel tutorialP;
	
	public static ColorPoolFrame frame=null;
	
	public volatile Thread thread;
	
	public ColorPoolFrame() {
		//inizializzazione, assegna il layout al container
		super("ColorPool");
		container = getContentPane();
		layout = new CardLayout();
		container.setLayout(layout);
		//imposto la dimensione e la posizione
		this.setSize(Settings.WIDTH, Settings.HEIGHT);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-Settings.WIDTH/2, dim.height/2-Settings.HEIGHT/2);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static ColorPoolFrame getFrame() {
		if(frame==null)
			frame = new ColorPoolFrame();
		return frame;
	}
	
	public StartPanel getStartPanel() {
		return startP;
	}
	
	public MenuPanel getMenuPanel() {
		return menuP;
	}
	
	public TutorialPanel getTutorialPanel() {
		return tutorialP;
	}
	
	//metodi per il thread
	public void run() {
		if(thread != null) { //per evitare errori logici e nullpointer exceptions
			thread.start();
		}
	}
	
	public void stop() {
		if(thread != null) {
			thread.interrupt();
			thread = null;
		}
	}
	
	public void stopGame() {
		if(thread != null) {
			thread.interrupt();
			thread = null;
		}
		container.remove(gameP);
		gameP = null;
		menu();
	}
	
	//mostra la schermata di inizio, gestendo anche il thread
	public void start() {
		startP = new StartPanel();
		startP.setFocusable(true);//focus per ascolto click
		//aggiunta al container, visualizzazione del pannello
		container.add("start", startP);
		layout.show(container, "start");

		//avvio delle animazioni
		thread = new Thread(new PanelLoop(startP));
		run(); 
		
		Settings.init();
	}
	
	//passaggio al pannello menu
	public void menu() {
		if(menuP == null) {
			menuP = new MenuPanel();
			menuP.setFocusable(true);
		}
		//avvio delle animazioni
		thread = new Thread(new PanelLoop(menuP));
		run();
		
		//aggiunta al container, visualizzazione del pannello
		if(!container.isAncestorOf(menuP))
			container.add("menu", menuP);
		layout.show(container, "menu");
		
	}
	//passaggio al pannello impostazioni
	public void settings() {
		SettingsDialog.showSettings();
	}
	
	//avvia il gioco secondo la modalità selezionata
	public void game(boolean gamemode) {
        Game.initGame(gamemode);
        gameP = new GamePanel();
		
		//bottone test utilizzato per riavviare il gioco da capo in fase di debugging
        if(Settings.DEBUGGING) {
        	TestButton testb = new TestButton();
        	testb.addActionListener(new TestButtonListener());
        	testb.setBounds(Settings.WIDTH-250, Settings.HEIGHT-60, 100, 30);
        	gameP.add(testb);
        }
        gameP.setFocusable(true);//focus per movimenti mouse
        //aggiunta al container, visualizzazione del pannello
        container.add("game", gameP);
        layout.show(container, "game");
        
        stop();
        //avvio del gioco
		thread = new Thread(new GameLoop(gameP));
		run();
	}
	
	//passaggio al pannello tutorial
	public void tutorial() {
		if(tutorialP == null) {
			tutorialP = new TutorialPanel();
			tutorialP.setFocusable(true);
		}
		//avvio delle animazioni
		thread = new Thread(new PanelLoop(tutorialP));
		run();
		
		//aggiunta al container, visualizzazione del pannello
		if(!container.isAncestorOf(tutorialP))
			container.add("tutorial", tutorialP);
		layout.show(container, "tutorial");
	}
	
	//informazioni sul gioco
	public void info() {
		MyOptionPane.infoPane();
	}
	//per visualizzare i record dei vari giocatori
	public void record() {
		Settings.throwError(1);
	}
	
	
	private static final long serialVersionUID = 588260456005796541L;

}
