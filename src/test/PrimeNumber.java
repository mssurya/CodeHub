package test;

public class PrimeNumber {
	public static void main(String[] args) {
		//long n = (long) Math.pow(2,282589933);
		System.out.println("State: " + isPrime(15485863));
	}

	static boolean isPrime(long n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i < n-1; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
