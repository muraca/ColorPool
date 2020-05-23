package colorpool.view;


import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import colorpool.config.Settings;
import colorpool.testbutton.*;
import colorpool.threads.GameLoop;
import colorpool.threads.Loop;
//JFrame personalizzato, per utilizzare al meglio il CardLayout
public class ColorPoolFrame extends JFrame {
	private CardLayout layout;
	private Container container;
	private StartPanel startP;
	private MenuPanel menuP;
	private SettingsPanel settingsP;
	
	private Pictures pictures;
	
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
		
		pictures = new Pictures();
	}
	
	public static ColorPoolFrame getFrame() {
		if(frame==null)
			frame = new ColorPoolFrame();
		return frame;
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
		pictures.initPictures();
	}
	
	//passaggio al pannello menu
	public void menu() {
		menuP = new MenuPanel(this);
		startP.setFocusable(true);
		//avvio delle animazioni
		thread = new Thread(new Loop(menuP));
		run();
		//aggiunta al container, visualizzazione del pannello
		container.add("menu", menuP);
		layout.show(container, "menu");
		
		
	}
	//passaggio al pannello impostazioni
	public void settings() {
		settingsP = new SettingsPanel();
		settingsP.setFocusable(true);
		
	}
	
	//avvia la modalità di gioco di allenamento
	public void training() {
		
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
        
        stop();
        //avvio del gioco
		thread = new Thread(new GameLoop(panel));
		run();
	}
	
	public Pictures getPictures() {
		return this.pictures;
	}
	
	
	private static final long serialVersionUID = 588260456005796541L;
	

}
