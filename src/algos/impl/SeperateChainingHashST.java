package algos.impl;

import algos.iface.ST;

public class SeperateChainingHashST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

	private int M = 97; //Some prime number

	private Node[] index = (Node[])new Object[M];

	private class Node {
		private Key key;

		private Value value;

		private Node next;

		public Node (Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	
	@Override
	public void put(Key key, Value value) {
		int keyHash = hash(key);
		
		// We need to check if the key already exists
		for (Node x = index[keyHash]; x!=null; x = x.next) {
			if(key.equals(x.key)) {
				x.value = value;
				return;
			}
		}
		index[keyHash] = new Node(key, value, index[keyHash]);
	}

	@Override
	public Value get(Key key) {
		int keyHash = hash(key);

		for (Node x = index[keyHash]; x!=null; x = x.next) {
			if(key.equals(x.key))
				return x.value;
		}
		return null;
	}

	@Override
	public void delete(Key key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		return 0;
	}

}
