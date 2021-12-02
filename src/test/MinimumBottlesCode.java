package test;

public class MinimumBottlesCode {
	public static void main(String[] args) {
		// pass in quantity through command-line arguments
		//int quantity = Integer.parseInt(args[0]);
		//System.out.println("min bottles " + minimumBottles(quantity));
		System.out.println("MINI="+minGlasses(5,8));

	}

	private static int minGlasses(int N, int K) {
		int count=0;
		
		for(int i=N;i>0;i--) {
			if(K%i !=0) {
				count++;
			}
		}
		
		return count;
	}

	public static int minimumBottles(int quantity) {

		// Company sells water bottles of 1litres, 5 litres, 7litres, & 10
		// litres
		int nums[] = { 1, 2, 3,4,5 };
		int minBottles = 0;
		int result = 0;
		/*
		 * Iterate the given combinations of bottles - 5 litres, 7litres, and
		 * 10litres(without 1litres). For Each Iteration : It finds the number
		 * of bottles required to fullfill the given quantity for the order. The
		 * final result is the least number of minBottles (bottles to be used)
		 */
		for (int i = 0; i < nums.length; i++) {

			System.out.println("Iteration " + nums[i] + " litres ");
			int perfectDivs = quantity / nums[i];

			int remaining = quantity % nums[i];

			if (remaining == 0) {
				minBottles = perfectDivs;
				System.out.println("bottles:- " + nums[i] + " lt: "
						+ perfectDivs);
			} else if (remaining == 5) {
				minBottles = perfectDivs + 1;
				System.out.println("bottles:- " + nums[i] + " lt: "
						+ perfectDivs + " + 5 lt: 1 ");
			} else if (remaining == 7) {
				minBottles = perfectDivs + 1;
				System.out.println("bottles:- " + nums[i] + " lt: "
						+ perfectDivs + " + 7 lt: 1 ");
			} else if (remaining > 7 && remaining < 10) {
				minBottles = perfectDivs + remaining % 7 + 1;
				System.out.println("bottles:- " + nums[i] + " lt: "
						+ perfectDivs + " + 7 lt: " + remaining % 7
						+ " + 1 lt: " + 1);
			} else if (remaining > 5 && remaining < 7) {
				minBottles = perfectDivs + remaining % 5 + 1;
				System.out.println("bottles:- " + nums[i] + " lt: "
						+ perfectDivs + " + 5 lt: " + remaining % 5
						+ " + 1 lt: " + 1);
			} else if (remaining < 5) { // satisfied by 1 litre bottles
				minBottles = perfectDivs + remaining;
				System.out.println("bottles:- " + nums[i] + " lt: "
						+ perfectDivs + " + 1 lt: " + remaining);
			}

			if (i == 0) {
				result = minBottles;
			}
			if (result > minBottles) {
				result = minBottles;
			}
			System.out.println(">>>>>>>total bottles " + minBottles);
		}
		
		return result;
	}
}
