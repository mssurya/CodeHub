package codility;

import java.util.HashMap;
public class MinimumPositiveInteger {

	public static void main(String[] args) {
		int[] A = {-1,-3};
		System.out.println(new MinimumPositiveInteger().solution(A));

	}
//O(n)
	public int solution(int[] A) {
		int smallestInteger=0;
		HashMap<Integer,Integer> integersMap = new HashMap<>();

		for(int i=0;i<A.length;i++)
			if(A[i]>0) integersMap.put(A[i],A[i]);
		//System.out.println("integers="+integersMap);
		
		int integerSize =integersMap.size()+1;
		
		for(int i=1;i<=integerSize;i++)
			if(i !=integersMap.getOrDefault(i, 0)) smallestInteger= i;
		
		return smallestInteger;
		
	}

}
