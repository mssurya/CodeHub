package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortAndDuplicateRemover {
	public static void main(String[] args) {
		int[] myArray = {1,12,7,3, 6, 9, 7, 15, 1, 8, 4, 3, 9, 4, 5};	
		System.out.println(removeDuplicates(sortedArray(myArray)));
	}
	public static int[] sortedArray(int[] array) {
		for (int i = 1;i < array.length; i++) {
			int current = array[i];
			int j = i - 1;
			while (j >= 0 && current < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			if(array[j + 1]!=current) {
			array[j + 1] = current;
			}
		}
		return array;
	}
	private static String removeDuplicates(int[] input) {
	    if (input == null || input.length <= 0) {
	      return input+"";
	    }
	    Set<Integer> mySet = new HashSet<>(input.length);
	    // set will reject all duplicates
	    for (int i : input) {
	    	mySet.add(i);
	    }
	    return Arrays.toString(mySet.toArray(new Integer[mySet.size()]));
	  }
}
