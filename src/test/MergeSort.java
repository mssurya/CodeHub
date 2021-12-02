package test;

public class MergeSort {
	    // Merges two subarrays of arr[].
	    // First subarray is arr[l..m]
	    // Second subarray is arr[m+1..r]
	    void merge(int num[], int left, int middle, int right)
	    {
	        // Find sizes of two subarrays to be merged
	        int n1 = middle - left + 1;
	        int n2 = right - middle;
	 
	        /* Create temp arrays */
	        int L[] = new int[n1];
	        int R[] = new int[n2];
	 
	        /*Copy data to temp arrays*/
	        for (int i = 0; i < n1; ++i)
	            L[i] = num[left + i];
	        for (int j = 0; j < n2; ++j)
	            R[j] = num[middle + 1 + j];
	 
	        /* Merge the temp arrays */
	 
	        // Initial indexes of first and second subarrays
	        int i = 0, j = 0;
	 
	        // Initial index of merged subarry array
	        int k = left;
	        while (i < n1 && j < n2) {
	            if (L[i] <= R[j]) {
	                num[k] = L[i];
	                i++;
	            }
	            else {
	                num[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (i < n1) {
	            num[k] = L[i];
	            i++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < n2) {
	            num[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	 
	    //Sort
	    void sort(int arr[], int l, int r)
	    {
	        if (l < r) {
	            // Get the middle point
	            int m =l+ (r-l)/2;
	 
	            // Sort both halves
	            sort(arr, l, m);
	            sort(arr, m + 1, r);
	 
	            // Merge the two halves into one
	            merge(arr, l, m, r);
	        }
	    }
	 
	    static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i = 0; i < n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }
	 
	    // Main method
	    public static void main(String args[])
	    {
	        int nums[] = { 12, 11, 13, 5, 6,6, 7 };
	 
	        System.out.println("Given Array");
	        printArray(nums);
	 
	        MergeSort ob = new MergeSort();
	        ob.sort(nums, 0, nums.length - 1);
	        System.out.println("Stable: "+ob.isStable(6,6));
	        System.out.println("\nSorted array");
	        printArray(nums);
	    }
	
    //Check if mergesort is stable
	 boolean isStable(int a, int b){
		 Integer aa = new Integer(a);
	     Integer bb = new Integer(b);
		if(aa==bb) {
    		return false;
    	}
    	if(aa.equals(bb)) {
    		return true;
    	}
		return false;

	  }

}
