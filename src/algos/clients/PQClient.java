package algos.clients;

import algos.iface.MaxPQ;
import algos.impl.MaxHeap;
import algos.utils.SortingAlgos;

public class PQClient {

	public static void main(String[] args) {
		Integer[] arr = {1,7345,784563, 42,447,2,7,46236,8,463,7,36,846,36,3,7345634,56,23847,456};

		Integer[] arr2 = arr.clone();
		SortingAlgos.mergeSort(arr2);

		System.out.println("Sorted Array");
		for(Integer item: arr2) {
			System.out.println(item);
		}

		System.out.println("Max heap contents");
		int capacity = 5;
		MaxPQ<Integer> maxPQ = new MaxHeap<Integer>(capacity);

		for(Integer item: arr) {
			System.out.println("Inserting: " + item);
			maxPQ.insert(item);

			if(maxPQ.size() == capacity)
				System.out.println("Deleting: " + maxPQ.delMax());
		}

		maxPQ.printElements();
	}

}
