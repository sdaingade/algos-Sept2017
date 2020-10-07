package algos.utils;

public class SortingAlgos {

//------------------------------------selectionSort------------------------------------------------
	public static void selectionSort(Comparable[] arr) {
		//Takes quadratic time even if the input is sorted
		int size = arr.length;

		for (int i=0; i < size; i++) {
			int min = i;
			for (int j = i+1; j<size; j++) {
				if (Utils.less(arr[j], arr[min]))
					min = j;
			}

			Utils.exch(arr, i, min);
		}
	}

//------------------------------------insertionSort------------------------------------------------
	public static void insertionSort(Comparable[] arr) {
		// If array is already sorted in ascending order, then O(n)
		// If array is sorted in descending order then O(n^2)
		int size = arr.length;

		for (int i=0; i< size; i++) {

			for (int j=i; j > 0; j--) {
				if(Utils.less(arr[j], arr[j-1]))
					Utils.exch(arr, j, j-1);
				else
					break;
			}
		}
	}

//------------------------------------mergeSort------------------------------------------------
	public static void mergeSort(Comparable[] arr) {
		// Merge sort requires O(n) additional space IMP!
		Comparable[] aux = new Comparable[arr.length];
		mergeSort(arr, aux, 0, arr.length - 1);
	}

	private static void mergeSort(Comparable[] arr, Comparable[] aux, int lo, int hi) {
		if (lo >= hi) return;
		
		int mid = lo + (hi - lo)/2;
		mergeSort(arr, aux, lo, mid);
		mergeSort(arr, aux, mid+1, hi);
		merge(arr, aux, lo, mid, hi);
	}
	
	private static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {
		for (int i = 0; i < arr.length; i++)
			aux[i] = arr[i];

		int i = lo;
		int j = mid + 1;

		for (int k = lo; k <= hi; k++) {
			if (i > mid) arr[k] = aux[j++];
			else if (j > hi) arr[k] = aux[i++];
			else if (Utils.less(aux[i], aux[j])) arr[k] = aux[i++];
			else arr[k] = aux[j++];
		}

	}
//--------------------------------------quick sort----------------------------------------------

	public static void quickSort(Comparable[] arr) {
		Utils.shuffle(arr);
		//System.out.println("Before");
		//for (Comparable elem : arr) {
		//	System.out.println(elem);
		//}
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(Comparable[] arr, int lo, int hi) {
		if(lo >= hi) return;
		
		int j = partition(arr, lo, hi);
		quickSort(arr, lo, j-1);
		quickSort(arr, j+1, hi);
	}

	private static int partition(Comparable[] arr, int lo, int hi) {
		int i = lo + 1;
		int j = hi;

		while(true) {
			while(Utils.less(arr[i], arr[lo]) && i<= hi)
				i++;

			while(Utils.less(arr[lo], arr[j]) && j>= lo)
				j--;

			if(i >= j) break;
			else Utils.exch(arr, i, j);
			
		}
		Utils.exch(arr, lo, j);
		return j;
	}

	//Find kth largest (Given an array of N items)
	// IMP Array is not sorted O(log n)
	public static Comparable select(Comparable[] arr, int k) {
		int lo = 0;
		int hi = arr.length - 1;

		Utils.shuffle(arr);

		while(hi > lo) {
			int j = partition(arr, lo, hi);
			if (k > j) lo = j + 1;
			else if (k < j) hi = j - 1;
			else return arr[k]; // k == j
		}

		return arr[k];
	}

	//3.1 Symbol Tables
	// Binary Search, Is value present in sorted array arr? O(log n)
	// IMP Array is sorted
	public static boolean binarySearch(Comparable[] arr, Comparable value) {
		int r = rank(arr, value);

		if(value.compareTo(arr[r]) == 0) return true;
		else return false;

	}
	//3.1 Symbol Tables
	// How many keys less than k?
	private static int rank(Comparable[] arr, Comparable value) {
		int lo = 0;
		int hi = arr.length;
		
		while (hi >= lo) {
			int mid = lo + (hi - lo)/2;
			int cmp = value.compareTo(arr[mid]);
			
			if (cmp < 0) hi = mid - 1;
			else if (cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}

}
