package codinghub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CheckIfStringsAreAnagrams {

	public static void main(String args[]) {
		String A = "cat";
		String B = "act";

//System.out.println(" Anagram " +CheckIfStringsAreAnagram( A, B));

		String[] cd = { "cat", "dog", "ogd", "act", "tca", "ofg" };
		AnagramArray(cd);
	}

	private static boolean CheckIfStringsAreAnagram(String A, String B) {
		boolean trn = true;
		if (A.length() != B.length())
			return false;

		char[] A1 = A.toCharArray();
		Arrays.sort(A1);
		char[] B1 = B.toCharArray();
		Arrays.sort(B1);
		for (int i = 0; i < A1.length; i++) {
			if (A1[i] == B1[i]) {
				System.out.println("Same " + A1[i] + " == " + B1[i]);
				continue;
			} else {
				trn = false;
				System.out.println("Same " + A1[i] + " == " + B1[i]);
				break;
			}
		}
		return trn;
	}

	private static void AnagramArray(String[] A) {
//String[] str = {"cat","dog","ogd","act","tca","ofg"}; 
		// act,cat,dog,
//act,act,act  <- act,cat,tca  <cat,6> 213
//act = cat,act,tca

//dog = dog,ogd

//fgo- = ofg
		/*
		 * 
		 * 1.We loop the array
		 * 
		 * 2.Map iko O(1) Map <String,List>
		 * 
		 * 3. We pick ch[i]
		 * 
		 * 4. Then sort ch[i] then loop aganist original array pick nw[i] sort and
		 * compare with ch[i]
		 * 
		 * 6. add ch[i] and ch[i] in map
		 * 
		 * O(n2) // space Hashmap (n) ,array of a word
		 */
		Map<String, List> map = new HashMap<String, List>(); // space (n)
		System.out.println("Anagram ORIGIBAL [] " + Arrays.toString(A));
		for (int i = 0; i < A.length; i++) { // second loop
			String word = A[i]; // space
			char[] wordArray = word.toCharArray(); // space
			Arrays.sort(wordArray); // O(n2)
			String tempWord = String.valueOf(wordArray);// space
			System.out.println(" word " + Arrays.toString(wordArray) + " word " + word + " tempWord " + tempWord);
			List<String> list = new ArrayList<String>(); // space
			for (int j = 0; j < A.length; j++) { // Second loop
				String newword = A[j]; // space
				char[] newwordArray = newword.toCharArray(); // space
				Arrays.sort(newwordArray);
				String tempnewWord = String.valueOf(newwordArray); // space
				System.out.println(" new word " + Arrays.toString(newwordArray) + " newword " + newword
						+ " tempnewWord " + tempnewWord);
				if (tempWord.equals(tempnewWord)) {
					list.add(newword);
					System.out.println("Anagram word " + word + " newword " + newword);
				}
			}
			if (list.size() > 1) {
				map.put(tempWord, list);
			}
		}
		System.out.println("matokeo " + map.toString());
		/*
		 * A tree map will sort keys in the map
		 * 
		 * TreeMap<String,String> map=new TreeMap<String,String>();
		 * map.put("Amit","Amit"); map.put("Ravi","Ravi"); map.put("yAmit","yAmit");
		 * map.put("Rahul","Rahul"); map.put("Vijay","Vijay");
		 */
		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());

		}
	}

}
