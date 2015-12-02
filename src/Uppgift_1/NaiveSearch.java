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
	private int count;

	public NaiveSearch(char[] f) {
		this.text = f;
		userInput();
		searchArray();
	}

	public void userInput() {
		String userInput = JOptionPane.showInputDialog(null, "Mata in den sträng som du vill söka efter");
		this.pattern = userInput.toCharArray();
		this.count = 0;
	}

	/**
	 * Metoden söker igenom en sträng efter en givet mönster. Om det blir match
	 * forstätter jämförelsen i en inre loop. Den inre loopen avbryts då
	 * mönstret inte matchar och går tillbaka till den yttre loopen som letar
	 * vidare i strängen.
	 */
	public void searchArray() {
		boolean isFound = false;
		int n = text.length;
		int m = pattern.length;
		System.out.println("Längden på n och m " + n + " " + m);

		int j = 0;
		for (int i = 0; i < (n - m + 1); i++) {
			System.out.println("i är: " + i);
			System.out.println("Söker i : " + text[i]);
			if (pattern[j] == (text[i])) {
				System.out.println("Aha! Hittade första bokstaven!");
				for (j = 1; j < m; j++) {
					System.out.println("Inre loop");
					if (pattern[j] == text[i + j]) {
						System.out.println("Match mellan: " + j + " " + pattern[j] + " och " + text[i + j]);
						if (j == m - 1) {
							System.out.println("Klart! Strängen befinner sig på indexposition: " + i);
							isFound = true;
						}
					} else {
						System.out.println("Falskt alarm! Vi hoppar ur den inre loopen J är: " + j);
						break;
					}
				}
			}
		}
		if (isFound) {
			System.out.println("Strängen är funnen!");
		} else {
			System.out.println("strängen är ej funnen");
		}

	}

}
