package aws.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumbersAddingToK {

	public static void main(String[] args) {
		int[] A = {2,5,3,7,6,4,1};
		int K=12;
        System.out.println(Arrays.toString(new NumbersAddingToK().twoElements(A, K)));
		;
	}
	/**
	 * Given unsorted array, find 2 elements that sum up to K e.g
	 * A[2,5,3,7,6,4,1] K =12
	 * 
	 * ans{5,7}
	 */
	
	int[] twoElements(int[] data, int sum) {
		
		 if (data !=null && data.length >= 2) {
             Map<Integer, Integer> hashMap= new HashMap<Integer, Integer>();
             for (int i = 0; i < data.length; i++) {
                 int remainingSum = sum - data[i];
                 if (!hashMap.containsKey(remainingSum)) {
                     hashMap.put(data[i],i);
                 } else {
                     System.out.println(data[i]+"+"+remainingSum+"="+sum);
                     return new int[] {data[i], remainingSum};
                 }
             }
             return null;
         } else {
             return null;
         }
	}
}
