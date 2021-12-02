package test;

public class EfficiencyIan {
	public static void main(String[] args) {
		int[] A = {4,6,2,2,6,6,1};
		System.out.println(solution(A));
	}
	public static int solution(int[] A) {
	    int N = A.length;
	    int result = 0;
	    for (int i = 0; i < N; i++) {
	    	result= getValueJ(N,A,i);
	    }
	    return result;
	}
	static int getValueJ(int N, int[] A, int i) {
		int r=0;
		 for(int j=0;j<N;j++){
	            if (A[i] == A[j]) {
	                r+= Math.max(r, Math.abs(i-j));
	            }
	        }
		return r;

	}
}
