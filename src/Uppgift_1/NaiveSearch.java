package Uppgift_1;

import javax.swing.JOptionPane;

/**
 * Användaren uppmanas mata in en sträng att söka efter. Klassen består av en sökfunktion 
 * som söker efter den inmatade strängen i en textfil.
 * @author emmashakespeare
 *
 */
public class NaiveSearch {
	private char[] strToSearchIn;
	private char[] strToSearchFor;

	public NaiveSearch(char[] f) {
		this.strToSearchIn = f;
	}
	
	public void userInput(){
		String userInput = JOptionPane.showInputDialog(null, "Mata in den sträng som du vill söka efter");
		
	}
	
	

}
