package algos.impl;

import algos.iface.ST;

public class LinearProbingHashST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
	private int M = 30000;
	
	private Key[] keys = (Key[]) new Object[M];
	
	private Value[] values = (Value[]) new Object[M];

	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	@Override
	public void put(Key key, Value value) {
		int i;

		for(i = hash(key); keys[i]!= null; i = (i + 1) % M) {
			if(key.equals(keys[i]))
				break;
		}
		keys[i] = key;
		values[i] = value;
	}

	@Override
	public Value get(Key key) {

		int i;
		for(i = hash(key); keys[i]!= null; i = (i + 1) % M) {
			if(key.equals(keys[i]))
				return values[i];
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
