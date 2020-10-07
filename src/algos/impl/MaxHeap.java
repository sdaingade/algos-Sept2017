package algos.impl;

import java.lang.reflect.Array;

import algos.iface.MaxPQ;
import algos.utils.Utils;

public class MaxHeap<T extends Comparable<T>> implements MaxPQ<T>{
	public final int capacity;
	public int N = 1;
	public T [] pq;

	@SuppressWarnings("unchecked")
	public MaxHeap(int capacity) {
		this.capacity = capacity;
		pq = (T[]) new Comparable[capacity + 1];
		//pq = (T[]) Array.newInstance(componentType, capacity + 1);
	}

	@Override
	public void insert(T t){
		if (N > capacity)
			throw new RuntimeException("Full capacity. Try delMax");
		
		pq[N] = t;
		swim(N);
		N++;
	}

	@Override
	public T delMax() {
		T max = pq[1];
		N--;
		Utils.exch(pq, 1, N);
		pq[N] = null;
		sink(1);
		return max;
	}

	@Override
	public boolean isEmpty() {
		return N==1;
	}

	@Override
	public T max() {
		if(isEmpty())
			throw new RuntimeException("MaxHeap is empty");

		return pq[1];
	}

	@Override
	public int size() {
		return N - 1;
	}
	
	private void swim(int k) {
		while(k > 1) {
			if(Utils.less(pq[k], pq[k/2])) break;
			Utils.exch(pq, k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k) {
		while(2*k < N) {
			int j = 2*k;
			if(j +1 < N && Utils.less(pq[j], pq[j+1]) ) j++;
			//TODO If less(pq[j], pq[k]) break;
			Utils.exch(pq, k, j);
			k = j;
		}
	}

	@Override
	public void printElements() {
		for(int i = 1; i < N; i++){
			System.out.println(pq[i]);
		}
	}
}
