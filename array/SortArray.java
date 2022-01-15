package array;

import java.util.Arrays;

public class SortArray {
	public static void main(String[] args) {
		int[] a = { 6, 7, 1,9, 4,2,8,14 };
		int sum =15;
		System.out.println(Arrays.toString(sortedArray(a)));
		System.out.println(sumOfArrays(a,sum));
	}

	public static int[] sortedArray(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int current = array[i];
			int j = i - 1;
			while (j >= 0 && current < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = current;
		}
		return array;
	}
	
	public static String sumOfArrays(int[] array, int sum) {
		String index="";
		for (int i = 1; i < array.length; i++) {
			//if(sum -array[i]<=array[i])
			for (int j = 0; j < i; j++) {
				if(array[i]+array[j] ==sum) {
					index += "i->"+array[i]+"====j->"+array[j]+" \t ";
				}
				
			}
		}
		return index;
	}
}
