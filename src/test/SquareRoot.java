package test;

public class SquareRoot {

	public static void main(String[] args) {
		int a =17;
		double b = 0.01;
		//System.out.println(isPrimeNumber(a));
		System.out.println("SQRT="+squareRoot(b));
	}
	
	static boolean isPrimeNumber(int a) {
		boolean prime =false;
		for(int i=2; i<a / 2;i++) {
			if(a % i==0) {
				prime=true;
				 break;
			}
		}
		if(!prime) {
			System.out.println(a+" is a prime number");
			prime=true;
		}else {
			System.out.println(a+" is not a prime number");
			prime=false;
		}
		return prime;
	}
	
	static double squareRoot(double a) {
		double sqrt = a/2;
		double sqrtHolder;
		do {
			sqrtHolder =sqrt;
			sqrt = (sqrtHolder +(a/sqrtHolder))/2;
			System.out.println("temp="+sqrtHolder+" squareroot="+sqrt);
		}while((sqrtHolder-sqrt) !=0);
		return sqrt;
	}
	
}
