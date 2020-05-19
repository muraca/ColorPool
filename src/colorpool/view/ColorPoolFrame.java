package colorpool.view;


import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JFrame;
import colorpool.config.Settings;
import colorpool.testbutton.*;
import colorpool.threads.GameLoop;
import colorpool.threads.Loop;

public class ColorPoolFrame extends JFrame {
	private CardLayout layout;
	private Container container;
	private StartPanel startP;
	private MenuPanel menuP;
	private SettingsPanel settingsP;
	
	public volatile Thread thread;
	
	//inizializzazione, assegna il layout al container
	public ColorPoolFrame() {
		super();
		container = getContentPane();
		layout = new CardLayout();
		container.setLayout(layout);
		
	}
	
	public StartPanel getStart() {
		return startP;
	}
	
	public MenuPanel getMenu() {
		return menuP;
	}
	
	//metodi per il thread
	public void run() {
		if(thread != null) { //per evitare errori logici e nullpointer exceptions
			thread.start();
		}
	}
	
	public void stop() {
		thread = null;
	}
	
	//mostra la schermata di inizio, gestendo anche il thread
	public void start() {
		startP = new StartPanel(this);
		startP.setFocusable(true);//focus per ascolto click
		//aggiunta al container, visualizzazione del pannello
		container.add("start", startP);
		layout.show(container, "start");
		//avvio delle animazioni
		thread = new Thread(new Loop(startP));
		run(); 
	}
	
	//passaggio al pannello menu
	public void menu() {
		menuP = new MenuPanel(this);
		startP.setFocusable(true);
		//aggiunta al container, visualizzazione del pannello
		container.add("menu", menuP);
		layout.show(container, "menu");
		//avvio delle animazioni
		thread = new Thread(new Loop(menuP));
		run();
		
	}
	//passaggio al pannello impostazioni
	public void settings() {
		settingsP = new SettingsPanel();
		settingsP.setFocusable(true);
		
	}
	
	//avvia la modalità di gioco di allenamento
	public void training() {
		stop();
		
		GamePanel panel = new GamePanel();
		//bottone test utilizzato per riavviare il gioco da capo in fase di debugging
        TestButton testb = new TestButton();
        testb.addActionListener(new TestButtonListener());
        testb.setBounds(Settings.WIDTH-250, 0, 100, 30);
        panel.add(testb);
        
        panel.setFocusable(true);//focus per movimenti mouse
        //aggiunta al container, visualizzazione del pannello
        container.add("game", panel);
        layout.show(container, "game");
        //avvio del gioco
		thread = new Thread(new GameLoop(panel));
		run();
	}
	
	
	
	private static final long serialVersionUID = 588260456005796541L;
	

}
