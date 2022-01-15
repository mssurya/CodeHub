package array;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Array numbers = new Array(3);
		numbers.insert(10);
		numbers.insert(20);
		numbers.insert(30);
		numbers.insert(40);
		numbers.insert(50);
		numbers.insert(60);
		
		numbers.removeAt(0);
		//System.out.println(numbers.indexOf(50));
		//numbers.print();
		
		//WORKING WITH ARRAYLIST
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.remove(3);
		
		System.out.println("list: "+list);
		System.out.println("array: "+Arrays.toString(list.toArray()));


	}
}
