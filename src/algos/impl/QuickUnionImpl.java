package algos.impl;

import algos.iface.UnionFind;

public class QuickUnionImpl implements UnionFind{
	private int [] id;
	private int count = 0;
	
	public QuickUnionImpl(int n) {
		count = n;
		id = new int [n];
		
		for (int i = 0; i < count; i++) {
			id[i] = i;
		}
	}

	private int findRoot(int i) {
		while(id[i] != i)
			i = id[i];

		return i;
	}

	@Override
	public void union(int p, int q) {
		int rootP = findRoot(p);
		int rootQ = findRoot(q);

		id[rootP] = rootQ;
	}

	@Override
	public boolean connected(int p, int q) {
		return findRoot(p) == findRoot(q);
	}

	@Override
	public int countComponents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printState() {
		for (int i=0; i < count; i++) {
			System.out.println("(" + i + ", " + id[i] + ")");
		}
	}
}
