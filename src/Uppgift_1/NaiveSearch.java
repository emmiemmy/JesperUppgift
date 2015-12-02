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
	private char[] text;
	private char[] pattern;

	public NaiveSearch(char[] f) {
		this.text = f;
		userInput();
		searchArray();
	}

	public void userInput() {
		String userInput = JOptionPane.showInputDialog(null,
				"Mata in den sträng som du vill söka efter");
		this.pattern = userInput.toCharArray();
	}
	
	public void makeLowercase(){
		
	}

	/**
	 * Metoden söker igenom en sträng efter en givet mönster. Om det blir match
	 * forstätter jämförelsen i en inre loop. Den inre loopen avbryts då
	 * mönstret inte matchar och går tillbaka till den yttre loopen som letar
	 * vidare i strängen.
	 */
	public void searchArray() {
		String pos = "";
		boolean isFound = false;
		int n = text.length;
		int m = pattern.length;

		int j = 0;
		for (int i = 0; i < (n - m + 1); i++) {
			System.out.println("Jämförelse mellan: " + text[i] + " och " + pattern[j]);
			for (j = 0; j < m; j++) {
				if (pattern[j] == text[i + j]) {
					System.out.println("Match mellan: " + j + " " + pattern[j]
							+ " och " + text[i + j]);
					if (j == m - 1) {
						System.out.println("Klart! Strängen befinner sig på indexposition: " + i);
						pos += i + " ";
						isFound = true;
						j = 0;
						break;
					}
				} else {
					System.out.println("Ingen matchning, öka i med 1: i="+i);
					break;
				}
			}
		}
		if (isFound) {
			System.out.println("Strängen är funnen på position: " + pos);
		} else {
			System.out.println("strängen är ej funnen");
		}

	}

}
