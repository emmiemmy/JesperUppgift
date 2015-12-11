package Uppgift_1;

import javax.swing.JOptionPane;

/**
 * Klassen gör en strängsökning med Knuth-Morris-Pratt-algoritmen.
 * 
 * @author Emma Shakespeare och Evelyn Gustavsson
 *
 */
public class KnuthMorrisPratt {
	private int[] prefix;
	private char[] text;
	private char[] pattern;
	private int counterN;
	private int counterM;
	private long KMPTime, startTime, stopTime;
	private String positionFound;

	/**
	 * Konstruktor som initierar värden för instansvariablerna och mäter tiden
	 * för textsökningen i nanosekunder. Information om algoritmens
	 * tidskomplexitet, antal karaktäristiska operationer för akuell sökning
	 * samt på vilken position i texten som textmönstret påträffats skrivs ut.
	 * Likaså görs utskrift för pattern och prefix som arrayer, efter
	 * användarens inmatning.
	 * 
	 * @param t
	 */
	public KnuthMorrisPratt(char[] t) {
		counterN = 0;
		counterM = 0;
		positionFound = "";
		this.text = t;
		userInput();
		System.out.println("Skriver ut text som en charArray:");
		printArray(text);
		startTime = System.nanoTime();
		this.prefix = partialMatchTable(pattern);
		System.out.println("Skriver ut pattern som en charArray:");
		printArray(pattern);
		System.out.println("Skriver ut prefix som en intArray:");
		printArray(prefix);
		search();
		stopTime = System.nanoTime();
		KMPTime = stopTime - startTime;
		System.out.println("Tid för Knuth-Morris-Pratt-algoritmen: " + KMPTime + " nanosekunder");
		System.out.println("Tidskomplexiteten för KMP-algoritmen är: O(n+m)");
		System.out.println("Antal karaktäristiska operationer för N är: " + (counterN + 2));
		System.out.println("Antal karaktäristiska operationer för M är: " + (counterM + 1));
		System.out.println("Matchning för strängen hittades på position: " + positionFound);
	}

	/**
	 * Läser in textmönstret som användaren matat in via en dialogruta.
	 * Omvandlar den inmatade strängen till en char-array.
	 */
	public void userInput() {
		String userInput = JOptionPane.showInputDialog(null, "Mata in den sträng som du vill söka efter");
		this.pattern = userInput.toCharArray();
	}

	/**
	 * Sköter utskrift av char-array.
	 * 
	 * @param array
	 */
	public void printArray(char[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/**
	 * Sköter utskrift av heltals-array.
	 * 
	 * @param array
	 */
	public void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/**
	 * Skapar en prefixtabell genom att söka efter de längsta prefixen som
	 * matchar med de längsta suffixen i char-arrayen. Skriver ut antal
	 * jämförelser som genomförts. Returnerar en heltalsarray med prefix.
	 * 
	 * @param p
	 * @return prefixArray
	 */
	public int[] partialMatchTable(char[] p) {
		System.out.println("partialMatchTable()");
		int[] prefixArray = new int[p.length];
		prefixArray[0] = 0;
		int a = 0;

		for (int b = 2; b < p.length; b++) {
			while (a > 0 && p[a] != p[b]) {
				a = prefixArray[a];
			}
			counterN++;
			System.out.println("counterN är: " + counterN);
			if (p[a] == p[b]) {
				a++;
			}
			prefixArray[b] = a;
		}
		System.out.println("Antal karaktäristiska operationer för N är: " + counterN);
		return prefixArray;
	}

	/**
	 * Söker efter det textmönster som matats in i aktuell textfil. Utskrift sker
	 * om en matchning påträffats och ifall hela textmönstret återfunnits i
	 * texten skrivs positionen ut. Notera att positionen skrivs ut för varje
	 * position textmönstret återfinns på.
	 */
	public void search() {
		System.out.println("search()");

		int i = 0; // Räknaren i texten som ska sökas i.
		int j = 1; // Räknaren i textmönstret.
		int k = 0; // Aktuell position.
		int n = text.length;
		int m = pattern.length;

		while (((n + 1) - k) >= m) {
			counterM++;
			while (j < m && text[i] == pattern[j]) {
				System.out.println("Match! jämför " + text[i] + " med " + pattern[j]);
				i++;
				j++;
			}
			if (j >= m) {
				positionFound += (k - 1) + ", ";
				System.out.println("Positionen för strängen är: " + (k - 1));
			}
			if (prefix[j - 1] > 0) {
				k = i - prefix[j - 1];
			} else {
				if (i == k) {
					i++;
				}
				k = i;
			}
			if (j > 1) {
				j = prefix[j - 1] + 1;
			}
		}
	}
}