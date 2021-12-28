package aws.sort;

import java.util.Arrays;
/**
 * 
 * @author sakawaelijahbob
 *
 *
 *Selection sort first finds the smallest element in the unsorted array and swaps it with the first element. 
 *Then it finds the second smallest element in the unsorted array and swaps it with the second element, 
 *and the algorithm keeps doing this until the entire array is sorted.
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] nums = { 12, 1, 8, 7, 5, 2 };
		System.out.println(Arrays.toString(new SelectionSort().selectionSort(nums)));
	}
	int[] selectionSort(int[] A) {
		int swap=Integer.MAX_VALUE;
		int minIndex=0;
		for(int i=0;i<A.length;i++) {
			minIndex=i;
			for(int j=i+1;j<A.length;j++) {
				if(A[j]<A[minIndex]) {
					minIndex=j;
				}
				
			}
			swap=A[minIndex];
			A[minIndex] = A[i];
			A[i]=swap;
			
		}
		return A;
		
	}

}
