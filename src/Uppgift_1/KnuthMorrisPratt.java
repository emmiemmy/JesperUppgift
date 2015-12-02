package Uppgift_1;

public class KnuthMorrisPratt {
	char[] prefix;
	char[] suffix;
	private char[] text;
	private char[] pattern;
	
	public void partialMatchTable() {
//		Prefix(p)
//		length = [p];
		prefix[1] = 0; 
		int a = 0;
		
		
		
	}
	
	public void search() {
		int i = 1;
		int j = 1;
		int k = 1;
		int n = 0;
		int m = 0;
		
		while ((n - k) >= m) {
			while (j < m  && text[i] == pattern[j]) {
				i++;
				j++;
				
				if(j > m) {
					System.out.println("Skriver ut k: " + k);
				}
				if (prefix[j-1] > 0) {
					
				}
			}
		}
		
	}
}