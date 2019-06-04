import javax.swing.JFrame; // program use swing JFrame
import javax.swing.JScrollPane; // program use swing JScrollPane
import javax.swing.JLabel; // program use swing JLabel
import javax.swing.JButton; // program use swing JButton
import javax.swing.JTextField; // program use swing JTextField
import javax.swing.JTextArea; // program use swing JTextArea
import javax.swing.JOptionPane; // program use swing JOptionPane

import java.awt.FlowLayout;  // program use awt FlowLayout
import java.awt.event.ActionListener; // program use awt ActionListener
import java.awt.event.ActionEvent; // program use awt ActionEvent

//declaration of class BatterUpGUI
public class BatterUpGUI extends JFrame {
	
		// create the instance of BatterUp
		BatterUp game = new BatterUp();
	
		// initializing JLabel, JButton, JTextFied, JTextArea, and JScrollPane
		JLabel l1;
		JLabel l2;
		JButton b1;
		JButton b2;
		
		JTextField inningText;
		JTextField teamText;
		
		JTextArea output;
		JScrollPane scrollPane;
		
		// Create and add widgets in the Constructor
		public BatterUpGUI() {
			
			// call superclass constructor
			super("BatterUp!");
			setLayout( new FlowLayout() ); // set frame layout
			
			l1 = new JLabel("Number of Innings"); // create lable for inning numbers
			add(l1); // add label to JFrame
			
			inningText = new JTextField(20); // construct textfield with 20 colums
			add(inningText); // add textfield to JFrame
			
			l2 = new JLabel("Team Name"); // create lable for team name
			add(l2); // add label to JFrame
			
			teamText = new JTextField(20); // construct textfield with 20 colums
			add(teamText); // add textfield to JFrame
			
			b1 = new JButton("Play"); // create play button
			add(b1); // add button to JFrame
			
			b2 = new JButton("Reset"); // create reset button
			add(b2); // add button to JFrame
			
			output = new JTextArea( 20, 50 ); // create text area
			scrollPane = new JScrollPane( output );
			add( scrollPane ); // add text area to JFrame
			
			// Disable editing
			output.setEditable( false );
			
			InnerBatterUp ibu = new InnerBatterUp();
			b1.addActionListener(ibu);
			b2.addActionListener(ibu);
			
			b2.setEnabled( false ); // disable editing
			output.setEnabled( false ); // disable editing
		} // end Constructor BatterUpGUI
		
		// inner class for button event handling
		private class InnerBatterUp implements ActionListener {
			// handle button event
			public void actionPerformed( ActionEvent e ) {
			
				// user pressed play button 
				if( e.getSource() == b1 ) {
					
					// if inning textfield is empty, show message dialog
					if( inningText.getText().equals("") ) {
						
						JOptionPane.showMessageDialog( null, "Please enter the number of innings", "Missing Data", JOptionPane.ERROR_MESSAGE );
					} 
					// if team name textfield is empty, show message dialog
					else if( teamText.getText().equals("") ) {

						JOptionPane.showMessageDialog( null, "Please enter a team name", "Missing Data", JOptionPane.ERROR_MESSAGE );
					} 
					// else, diplay game result
					else {
						
						// Use static method parseIntin class Integer to convert String to int
						Integer innings = Integer.parseInt(inningText.getText());
						
						b1.setEnabled( false );
						b2.setEnabled( true );
						inningText.setEnabled( false );
						teamText.setEnabled( false );
						output.setEnabled( true );
						
						String gameResult = game.play( innings ); // call play method
						
						// Append contents with additional text
						StringBuilder sb = new StringBuilder(20);
						sb.append( "Team " + teamText.getText() + " is playing!" + "\n" ).append(gameResult);
						
						// Erase contents with replace text
						output.setText( sb.toString() );
					}
				} // end b1 actionPerformed
				
				// user pressed reset button
				if( e.getSource() == b2 ) {
					
					b1.setEnabled( true );
					b2.setEnabled( false );
					inningText.setEnabled( true );
					inningText.setText("");
					teamText.setEnabled( true );
					teamText.setText("");
					output.setText("");
					output.setEnabled( false );
				} // end b2 actionPerformed
					
			} // end actionPerformed
		} // end InnerBatterUp
		
}  // end class BatterUpGUI

