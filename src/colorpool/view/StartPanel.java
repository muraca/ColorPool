package colorpool.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.JTextField;

import colorpool.config.BitBold;
import colorpool.control.StartListener;

public class StartPanel extends JPanel {
	private Image foreground = null;
	private Image background = null;
	private Image loadingImg = null;
	private JTextField text;
	
	private boolean loading; //se il caricamento è in corso, allora la pressione di un tasto non porta al 
	private boolean toWrite; 
	
	public StartPanel() {
		setLayout(null); //per il corretto posizionamento delle immagini
		
		loading = true;
		toWrite = true;
		
		StartListener listener = new StartListener(ColorPoolFrame.getFrame());
		addKeyListener(listener);
		addMouseListener(listener);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(background!=null)
			g.drawImage(background, 0, 0, null);
		if(foreground!=null)
			g.drawImage(foreground, 0, 0, null);
		if(loadingImg!=null)
			g.drawImage(loadingImg, 0, 0, null);
		//se il caricamento è stato completato allora l'immagine di caricamento non esiste
		else if(!loading&&toWrite) //il testo viene scritto solo se non è già stato scritto
			writePress();
	}	
	
	public void setBackground(Image bg) {
		this.background = bg;
	}
	
	public void setForeground(Image fg) {
		this.foreground = fg;
	}
	
	public void setLoadingImg(Image l) {
		this.loadingImg = l;
	}
	
	public boolean isLoading() {
		return loading;
	}
	
	//a caricamento completato, l'immagine di caricamento scompare
	public void completed() {
		loadingImg = null;
		loading = false;
		repaint();
	}
	
	//inizializza la JTextField e fa in modo che il testo venga scritto una volta sola
	private void writePress() { 
		toWrite = false;
		text = new JTextField();
		text.setBounds(300, 580, 800, 64);
		text.setForeground(Color.WHITE);
		text.setFont(BitBold.getFont().deriveFont(40f));
		text.setOpaque(false);
    	text.setBorder(null);
    	text.setEditable(false);
		text.setText("PRESS ANY KEY TO START");
		text.setHorizontalAlignment(JTextField.CENTER);
		this.add(text);
	}
	
	private static final long serialVersionUID = 5913352926465412444L;

	

}
