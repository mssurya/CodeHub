package codewithmosh;

public class BigO {
	
	public static void main(String[] args) {
		int [] n = {10,2,3,4,5,6};
		log(n);
	}

	static void log(int[] a) {
		for(int n:a) {
			for(int m:a) {
				System.out.println(n+", "+m);
			}		}
	}
}
