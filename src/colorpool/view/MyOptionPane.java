package colorpool.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import colorpool.config.Pictures;
import colorpool.config.Settings;
import colorpool.core.Game;

//vari JOptionPane personalizzati col colore di sfondo
public class MyOptionPane {
	
	//messaggio d'errore, richiamato da Settings.throwError(int)
	public static void errorPane(int id, String text) {
		JOptionPane errorpane = new JOptionPane(text, JOptionPane.ERROR_MESSAGE);
		errorpane.setOpaque(true);

		if(Pictures.getPictures().getErrorIcon() != null)
			errorpane.setIcon(new ImageIcon(Pictures.getPictures().getErrorIcon()));
		
		colorComponentsBG(errorpane, Settings.BACKGROUNDCOLOR);
		errorpane.setBackground(Settings.BACKGROUNDCOLOR);
		
		
		JDialog dialog = errorpane.createDialog(ColorPoolFrame.getFrame(), "Error "+id);
		
		dialog.setVisible(true);
		
		if(errorpane.getValue() != null && id == 2) {
			System.exit(2);
		}
	}
	
	//pannello che mostra la pallina imbucata
	public static void pottedBallPane(ImageIcon icon, boolean goodShot) {
		String text, title;
		if(goodShot) {
			text = "Good shot!";
			title = "New point!";
		}
		else {
			text = "Wrong ball potted!";
			title = "Oh, no!";
		}
		
		JOptionPane pottedballpane = new JOptionPane(text, JOptionPane.INFORMATION_MESSAGE);
		pottedballpane.setIcon(icon);
		
		colorComponentsBG(pottedballpane, Settings.BACKGROUNDCOLOR);
		pottedballpane.setBackground(Settings.BACKGROUNDCOLOR);
		
		JDialog dialog = pottedballpane.createDialog(ColorPoolFrame.getFrame(), title);
		dialog.setVisible(true);
	}
	
	//pannello mostrato a fine partita, dice quale giocatore ha vintp
	public static int gameOverPane() {
    	String[] options = {"Quit", "Play"};
    	StringBuffer message = new StringBuffer();
    	if(Game.getGame().gamemode() == Game.MULTIPLAYER) {
    		
    		if(Game.getGame().getPoints1() < Game.getGame().getPoints2() || (Game.getGame().turn() == Game.PLAYER1 && Game.getGame().getPoints1() == Game.getGame().getPoints2()))
    			message.append("Player 2 ");
    		else
    			message.append("Player 1 ");
    		message.append("won the match! \n");
    	}
    	message.append("Do you want to play again?");
    		
    	JOptionPane gameoverpane = new JOptionPane(message.toString(), JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options, options[1]);
    	gameoverpane.setOpaque(true);
    	
    	colorComponentsBG(gameoverpane, Settings.BACKGROUNDCOLOR);
    	gameoverpane.setBackground(Settings.BACKGROUNDCOLOR);
    	
    	JDialog dialog = gameoverpane.createDialog(ColorPoolFrame.getFrame(), "Game Over!");
		dialog.setVisible(true);
		
		return (gameoverpane.getValue() == "Play") ? 1 : 0;
	}
	
	//pannello che viene mostrato alla pressione del pulsante home durante la partita
	public static int homebuttonPane() {
		String[] options = {"Quit", "Play"};
    	JOptionPane homebuttonpane = new JOptionPane("Do you really want to quit?", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options, options[1]);
    	homebuttonpane.setOpaque(true);
    	
    	colorComponentsBG(homebuttonpane, Settings.BACKGROUNDCOLOR);
    	homebuttonpane.setBackground(Settings.BACKGROUNDCOLOR);
		
		JDialog dialog = homebuttonpane.createDialog(ColorPoolFrame.getFrame(), "Quit game");
		dialog.setVisible(true);
		
		return (homebuttonpane.getValue() == "Play") ? 1 : 0;
	}
	
	//pannello delle info sul gioco, accessibile nel menu
	public static void infoPane() {
		JOptionPane infopane = new JOptionPane("©2020 Matteo Muraca, made for IGPE Course", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, new ImageIcon(Pictures.getPictures().getInfoIcon()));
		infopane.setOpaque(true);
		
		colorComponentsBG(infopane, Settings.BACKGROUNDCOLOR);
		infopane.setBackground(Settings.BACKGROUNDCOLOR);
		
		JDialog dialog = infopane.createDialog(ColorPoolFrame.getFrame(), "Info");
		dialog.setVisible(true);
	}
	
	//metodo ricorsivo per colorare tutti i component di un container
	static void colorComponentsBG(Container cont, Color col) {
		Component[] m = cont.getComponents();

	    for(int i = 0; i < m.length; i++){

	        if(m[i].getClass().getName() == "javax.swing.JPanel")
	            m[i].setBackground(col);

	        if(cont.getClass().isInstance(m[i]));
	            colorComponentsBG((Container)m[i], col);
	    }
	}
	
}
