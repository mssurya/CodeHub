package test;

import java.util.Arrays;

public class Recursion {

	public static void main(String[] args) {
		String s = "Sakawa";
		int a = 46781;
		//int[] arr = { 1, 0, 0, 0, 2, 0, 4, 3, 1 };
		int[] arr = {5,2,8,14,1,16};
		String pal = "";
		//System.out.println(reverse(s));
		//System.out.println(reverseInt(a));
		//System.out.println(palindrome(pal));
		sortAlgorithm(arr);

	}

	// O(n)
	static String reverse(String S) {

		if (S.isEmpty()) {
			return S;
		}
		return reverse(S.substring(1)) + S.charAt(0);
	}

	// O(n)
	static int reverseInt(int a) {
		int x = 0;
		while (a != 0) {
			x = (x * 10) + (a % 10);
			a /= 10;
		}
		return x;
	}

//   O(n)
	static boolean palindrome(String str) {
		str.toUpperCase();
		boolean palStr = false;
		int i = 0;
		int j = str.length() - 1;
		while (i <= j) {
			if (str.charAt(i) == str.charAt(j) || str.charAt(i) == str.charAt(j)) {
				palStr = true;
			} else {
				return false;
			}
			i++;
			j--;
		}
		return palStr;
	}

	static void sortAlgorithm(int a[]) {
		System.out.println(Arrays.toString(a));
		int min = a[0];
		int [] b = new int [a.length];
		for(int i=0;i<a.length;i++) {
			if(a[i]<min) {
				min=a[i];
				//return;
				for(int j =0;j<i;j++) {
					b[j]=a[i];
				}
				//System.out.println("min: "+min);
				b[i]=min;
			}
			b[i]=min;
		}
		System.out.println("b: "+Arrays.toString(b));

	}
}
