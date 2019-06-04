/*Name: Jaehyung Kim
ID Number: 47248972
Lab 8-Fall 2018*/

import javax.swing.JFrame; // program use swing JFrame

//declaration of class GUILauncher
public class GUILauncher {

	public static void main(String[] args) {
		
		BatterUpGUI theGame = new BatterUpGUI(); // create theGame
		
		theGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theGame.setSize(660, 450); // set frame size
		theGame.setVisible(true); // display frame
		
	} // end main method
} // end class GUILauncher
