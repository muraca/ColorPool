package colorpool.view;

import java.awt.Color;

import javax.swing.JColorChooser;

import colorpool.config.Settings;

public class MyColorPicker {

	public static void pick(int type) {
		Color initialColor;
		String title;
		switch(type) {
			case 1:
				initialColor = Settings.player1color;
				title = "Pick a color for Player 1";
				break;
				
			case 2:
				initialColor = Settings.player2color;
				title = "Pick a color for Player 1";
				break;	
				
			default:
				initialColor = Settings.singleplayercolor;
				title = "Pick a color for Player";
				break;
		}
		
		Color newColor = JColorChooser.showDialog(SettingsDialog.getWindows()[0],title,initialColor);    
		
		switch(type) {
		case 1:
			Settings.player1color = newColor;
			break;
			
		case 2:
			Settings.player2color = newColor;
			break;
			
		default:
			Settings.singleplayercolor = newColor;
			break;
	}
		
	}

}
