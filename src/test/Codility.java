package test;

import java.util.ArrayList;

public class Codility {
	static ArrayList<Integer> a=null;
	public static void main(String[] a) {
		int n = 5;
		int k = 8;
		String str ="Sskkaa";
		//numberOfGlasses(n, k);
		System.out.println("ABSOLUTE: ");
		System.out.println("MAX: "+Integer.MAX_VALUE);
		System.out.println("MIN: "+Integer.MIN_VALUE);
		
		
		
		System.out.println(solution(str));

	}

	private static void numberOfGlasses(int n, int k) {
		a = new ArrayList<>();
		for (int i = n; i > 0; i--) {	
			a.add(i);			
		}
		System.out.println("newArray= " + a);		

	}
	    public static String solution(String S) {
	        int[] occurrences = new int[26];
	        for (char ch : S.toLowerCase().toCharArray()) {
	        	//System.out.println(ch);
	            occurrences[ch - 'a']++;
	            
	        }
	        char best_char = 'a';
	        int  best_res  = 0;
	        for (int i = 0; i < 26; i++) {
	            if (occurrences[i] > best_res) {
	                best_char = (char)((int)'a' + i);
	                best_res  = occurrences[i];
	            }
	        }
	        return Character.toString(best_char);
	    }
}
