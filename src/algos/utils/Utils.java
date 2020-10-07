package algos.utils;

import java.util.Random;

public class Utils {
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void exch(Comparable[] arr, int i, int j) {
		Comparable tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	@SuppressWarnings("rawtypes")
	public static void shuffle(Comparable[] arr) {
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			int r = rand.nextInt(i+1);
			exch(arr, r, i);
		}
	}
}
