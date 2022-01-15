package algorithms;

public class BinarySearch {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int target = 6;
		System.out.println(new BinarySearch().search(a, target));
	}

	/**
	 * O(log n) -->performance
	 * 
	 */
	boolean search(int[] a, int t) {
		int start = 0;
		int end = a.length - 1;
		int mid = (start + end) / 2;
		while (start <= end) {
			if (a[mid] < t) 
				start = mid + 1;
			 else if (a[mid] == t) 
				return true;
			 else 
				end = mid - 1;
			
			mid = (start + end) / 2;
		}
		if (start > end) 
			System.out.println("Element is not found!");
		

		return false;

	}
}
