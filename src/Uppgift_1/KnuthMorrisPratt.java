package Uppgift_1;

import javax.swing.JOptionPane;

public class KnuthMorrisPratt {
	private int[] prefix;
	private char[] text;
	private char[] pattern;

	public KnuthMorrisPratt(char[] t) {
		this.text = t;
		userInput();
		System.out.println("Skriver ut text som en charArray:");
		printArray(text);
		this.prefix = partialMatchTable(pattern);
		System.out.println("Skriver ut pattern som en charArray:");
		printArray(pattern);
		System.out.println("Skriver ut prefix som en intArray:");
		printArray(prefix);
		search();
	}

	public void userInput() {
		String userInput = JOptionPane.showInputDialog(null,
				"Mata in den sträng som du vill söka efter");
		this.pattern = userInput.toCharArray();
	}

	public void printArray(char[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	public void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	public int[] partialMatchTable(char[] p) {
		System.out.println("partialMatchTable()");
		int[] prefixArray = new int[p.length];
		// prefixArray[1] = 0;
		prefixArray[0] = 0;
		int a = 0;
		for (int b = 2; b < p.length; b++) {
			// for (int b = 1; b < p.length; b++) {
			while (a > 0 && p[a] != p[b]) {
				a = prefixArray[a];
			}
			if (p[a] == p[b]) {
				a++;
			}
			prefixArray[b] = a;
		}
		return prefixArray;
	}

	public void search() {
		System.out.println("search()");

		// int i = 1; // Eventuellt ändra till 0.
		// int j = 1;
		// int k = 1;
		int i = 0;
		int j = 0;
		int k = 1;
		int n = text.length;
		int m = pattern.length;

		while ((n + 1 - k) >= m) {
			while (j < m && text[i] == pattern[j]) {
				System.out.println("Match! jämför " + text[i] + " med "
						+ pattern[j]);
				i++;
				j++;
			}
			if (j >= m) {
				System.out.println("Positionen för strängen är: " + (k-1));
			}
			if (prefix[j - 1] > 0) {
				k = i - prefix[j - 1];
			} else if (i == k) {
				i++;
			}
			k = i;

			if (j > 1) {
				j = prefix[j - 1] + 1;
			}
		}
	}
}