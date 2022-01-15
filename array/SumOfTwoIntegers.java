package array;

public class SumOfTwoIntegers {
	public static void main(String[] args) {
		String message ="welcome";
		System.out.println(reverse(message));
	}
	
	static int summation(int [] a, int b) {
		for(int i =0; i<a.length; i++) {
			if(i< a.length-1) {
				
			}
		}
		
		return 0;
	}
	
	static String reverse(String reverse) {
		String reversed="";
		for(int i=reverse.length()-1;i>=0;i--) {
			reversed+=reverse.charAt(i);
			//System.out.println(reverse.charAt(i));
		}
		return reversed;
	}

}
