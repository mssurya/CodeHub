package algorithms;

public class LinearSearch {
	public static void main(String[] args) {
		int[] a = { 9, 2, 3, 6, 4, 8, 5, 7, 1, 6 };
		int target = 7;
		System.out.println(isTargetAvailable(a, target));
	}

	static boolean isTargetAvailable(int[] a, int t) {
		boolean found = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == t) {
				found = true;
			}
		}
		return found;
	}
}
