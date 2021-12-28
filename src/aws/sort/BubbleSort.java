package aws.sort;

import java.util.Arrays;
/**
 *  
 * 
 * @author sakawaelijahbob
 * 
 * Bubble sort is a simple sorting algorithm that compares adjacent elements of an array
 * and swaps them if the element on the right is smaller than the one on the left.
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] nums = { 4,12, 1, 8, 7, 5, 2 };
		System.out.println(Arrays.toString(new BubbleSort().bubbleSort(nums)));

	}

	int[] bubbleSort(int[] A) {
		int swap = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length - 1 - i; j++) {
				if (A[j] > A[j + 1]) {
					swap = A[j + 1];
					A[j + 1] = A[j];
					A[j] = swap;
				}
			}

		}
		return A;

	}

}
