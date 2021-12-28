package aws.sort;

import java.util.Arrays;

/**
 * 
 * @author sakawaelijahbob
 *
 *
 *         most efficient sorting algorithm.
 *
 *         Insertion sort is a sorting algorithm that places an unsorted element
 *         at its suitable place in each iteration.
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] nums = { 12, 1, 8, 7, 5, 2 };
		int[] sortedArray = new InsertionSort().sort(nums);// sort
		int num = new InsertionSort().find(sortedArray, 7);// find num(7)

		System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
		System.out.println("Index Of 7: " + num);
	}

	// O(n^2)
	int[] sort(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int current = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > current) {
				A[j + 1] = A[j];
				j = j - 1;
			}
			A[j + 1] = current;
		}
		return A;

	}

	// O(log n)
	int find(int[] A, int num) {
		int low = 0;
		int high = A.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (A[mid] == num) {
				return mid;
			}
			if (A[mid] < num) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;

	}

	// O(n)
	int[] insertion(int[] A, int num) {
		//implementation pending
		
		return A;

	}
	
	// O(n)
		int[] deletion(int[] A, int num) {
			//implementation pending

			return A;

		}


}
