package algorithms;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] numbers = { 2, 8, 5, 2, 14, 5, 3, 9, 6, 2, 1 };
		InsertionSort sort = new InsertionSort();
		sort.sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}

}
