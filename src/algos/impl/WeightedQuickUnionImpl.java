package algos.impl;

import algos.iface.UnionFind;

public class WeightedQuickUnionImpl implements UnionFind {
	private int[] id;
	private int[] size;
	private int count = 0;

	public WeightedQuickUnionImpl(int n) {
		count = n;
		id = new int[n];
		size = new int[n];
		
		for(int i = 0; i < count; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	@Override
	public void union(int p, int q) {
		int rootP = findRoot(p);
		int rootQ = findRoot(q);
		
		if (size[rootP] > size[rootQ]) {
			id[rootQ] = rootP;
			size[rootP] = size[rootP] + size[rootQ]; 
		} else {
			id[rootP] = rootQ;
			size[rootQ] = size[rootQ] + size[rootP];
		}
	}

	@Override
	public boolean connected(int p, int q) {
		System.out.println("P: " + p + ", rootP: " + findRoot(p) + ", Q: " + q + ", rootQ: " + findRoot(q)); 
		return findRoot(p) == findRoot(q);
	}

	@Override
	public int countComponents() {
		return 0;
	}

	@Override
	public void printState() {
		System.out.println("id:");
		for (int i=0; i < count; i++) {
			System.out.println("(" + i + ", " + id[i] + ")");
		}
		System.out.println("size:");
		for (int i=0; i < count; i++) {
			System.out.println("(" + i + ", " + size[i] + ")");
		}
	}

	private int findRoot(int i) {
		while(id[i] != i)
			i = id[i];

		return i;
	}

}
