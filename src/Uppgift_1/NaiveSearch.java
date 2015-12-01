package Uppgift_1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Användaren uppmanas mata in en sträng att söka efter. Klassen består av en
 * sökfunktion som söker efter den inmatade strängen i en textfil.
 * 
 * @author emmashakespeare
 *
 */
public class NaiveSearch {
	private char[] searchIn;
	private char[] searchFor;
	private int count;

	public NaiveSearch(char[] f) {
		this.searchIn = f;
		userInput();
		startSearch();
	}

	public void userInput() {
		String userInput = JOptionPane.showInputDialog(null,
				"Mata in den sträng som du vill söka efter");
		this.searchFor = userInput.toCharArray();
		this.count = 0;

	}

	public void searchArray() {
		for (int i = 0; i < searchFor.length; i++) {
			if(count == searchFor.length){
				System.out.println("Vi är klara!");
			}
			while(searchFor[i]==searchIn[i]){
				System.out.println("match!");
				count++;
				
			}
		}

	}

	public void startSearch() {
		searchArray();

	}

}
