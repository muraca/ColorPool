package colorpool.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import colorpool.config.Pictures;

//vari JOptionPane personalizzati col colore di sfondo
public class MyOptionPane {
	
	private static Color backgroundColor = new Color(0, 105, 48);
	
	public static void errorPane(int id, String text) {
		JOptionPane errorpane = new JOptionPane(text, JOptionPane.ERROR_MESSAGE);
		errorpane.setOpaque(true);
		
		colorComponentsBG(errorpane, backgroundColor);
		errorpane.setBackground(backgroundColor);
		
		JDialog dialog = errorpane.createDialog(ColorPoolFrame.getFrame(), "Error "+id);
		dialog.setVisible(true);
	}
	
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
		
		colorComponentsBG(pottedballpane, backgroundColor);
		pottedballpane.setBackground(backgroundColor);
		
		JDialog dialog = pottedballpane.createDialog(ColorPoolFrame.getFrame(), title);
		dialog.setVisible(true);
	}
	
	public static int gameOverPane() {
    	String[] options = {"Quit", "Play"};
    	JOptionPane gameoverpane = new JOptionPane("Do you want to play again?", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options, options[1]);
    	gameoverpane.setOpaque(true);
    	
    	colorComponentsBG(gameoverpane, backgroundColor);
    	gameoverpane.setBackground(backgroundColor);
    	
    	JDialog dialog = gameoverpane.createDialog(ColorPoolFrame.getFrame(), "Game Over!");
		dialog.setVisible(true);
		
		return (gameoverpane.getValue() == "Play") ? 1 : 0;
	}
	
	public static int homebuttonPane() {
		String[] options = {"Quit", "Play"};
    	JOptionPane homebuttonpane = new JOptionPane("Do you really want to quit?", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options, options[1]);
    	homebuttonpane.setOpaque(true);
    	
    	colorComponentsBG(homebuttonpane, backgroundColor);
    	homebuttonpane.setBackground(backgroundColor);
		
		JDialog dialog = homebuttonpane.createDialog(ColorPoolFrame.getFrame(), "Quit game");
		dialog.setVisible(true);
		
		return (homebuttonpane.getValue() == "Play") ? 1 : 0;
	}
	
	public static void infoPane() {
		JOptionPane infopane = new JOptionPane("©2020 Matteo Muraca, made for IGPE Course", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, new ImageIcon(Pictures.getPictures().getInfoIcon()));
		infopane.setOpaque(true);
		
		colorComponentsBG(infopane, backgroundColor);
		infopane.setBackground(backgroundColor);
		
		JDialog dialog = infopane.createDialog(ColorPoolFrame.getFrame(), "Info");
		dialog.setVisible(true);
	}
	
	private static void colorComponentsBG(Container cont, Color col) {
		Component[] m = cont.getComponents();

	    for(int i = 0; i < m.length; i++){

	        if(m[i].getClass().getName() == "javax.swing.JPanel")
	            m[i].setBackground(col);

	        if(cont.getClass().isInstance(m[i]));
	            colorComponentsBG((Container)m[i], col);
	    }
	}
	
}
