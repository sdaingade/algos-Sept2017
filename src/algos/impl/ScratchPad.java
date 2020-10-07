package algos.impl;
import java.util.Arrays;

public class ScratchPad {

	public static void sortInts() {
		int[] a = {1,25,7,3,4};
		
		Arrays.sort(a);
		for (int elem: a) {
			System.out.println(elem);
		}
	}

	public static void main(String[] args) {
		sortInts();
	}

}
