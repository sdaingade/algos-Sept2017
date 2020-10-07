package algos.impl;

import algos.iface.UnionFind;

public class QuickFindImpl implements UnionFind{
	
	private int[]  id = null;
	private int count = 0;

	public QuickFindImpl(int n) {
		count = n;
		id = new int[n];
		
		for (int i=0; i < count; i++) {
			id[i] = i;
		}
	}

	@Override
	public void union(int p, int q) {
		int oldId = id[p];
		int newId = id[q]; 
		for (int i=0; i < count; i++) {
			if(id[i] == oldId)
				id[i] = newId;
		}
	}

	@Override
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	@Override
	public int countComponents() {
		return 0;
	}

	@Override
	public void printState() {
		for (int i=0; i < count; i++) {
			System.out.println("(" + i + ", " + id[i] + ")");
		}

	}

}
