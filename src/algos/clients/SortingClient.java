package algos.clients;

import algos.utils.SortingAlgos;

public class SortingClient {

	public static void main(String[] args) {
		Integer[] arr = {1,7345,784563, 42,447,2,7,46236,8,463,7,36,846,36,3};
		
		//SortingAlgos.selectionSort(arr);
		SortingAlgos.mergeSort(arr);
		
		//SortingAlgos.quickSort(arr);

		System.out.println("After");
		for (Integer elem : arr) {
			System.out.println(elem);
		}

		System.out.println("Pos 6: " + SortingAlgos.select(arr, 6));
		
		System.out.println("Is 447 present ? " + SortingAlgos.binarySearch(arr, 447));
		System.out.println("Is 992 present ? " + SortingAlgos.binarySearch(arr, 992));
	}

}

