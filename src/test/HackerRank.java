package test;

public class HackerRank {
 public static void main(String[] args) {
	int i =010;
	int j=07;
	System.out.println(i);
	System.out.println(j);
	
	try {
		Float f=new Float("3.0");
		int x =f.intValue();
		byte b =f.byteValue();
		double d = f.doubleValue();
		System.out.println(x+b+d);
	}catch(NumberFormatException e) {
		System.out.println("bad number");
	}
	
	
	System.out.println("00003750".toString().substring(0,6 )+"."+"00003750".toString().substring(6));
	
	

}
}
