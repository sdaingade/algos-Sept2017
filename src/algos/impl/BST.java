package algos.impl;

import algos.iface.ST;

public class BST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

	private class Node {
		private Key key;

		private Value value;

		private Node left;

		private Node right;
		
		private int count;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
			this.count = 1;
		}
	}
	
	private Node root;

	@Override
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value) {
		if(x == null) return new Node(key, value);
		
		int cmp = key.compareTo(x.key);

		if (cmp < 0) 
			x.left = put(x.left, key, value);
		else if (cmp > 0) 
			x.right = put(x.right, key, value);
		else 
			x.value = value;

		x.count = 1 + size(x.left) + size(x.right);
		return x;

	}
	
	@Override
	public Value get(Key key) {
		Node x = root;
		
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0) x = x.left;
			else if (cmp > 0) x = x.right;
			else return x.value;
		}

		return null;
	}
	
	public Value getRecursive(Key key) {
		return getRecursive(root, key);
	}
	private Value getRecursive(Node x, Key key) {
		if (x == null) return null;
		
		int cmp = key.compareTo(x.key);
		
		if (cmp < 0)
			return getRecursive(x.left, key);
		else if (cmp > 0)
			return getRecursive(x.right, key);
		else
			return x.value;
	}

	@Override
	public void delete(Key key) {
		root = delete(root, key);
	}

	public Node delete(Node x, Key key) {
		if (x == null) return null;
		
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.left == null) return x.right;
			if (x.right == null) return x.left;
			
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}

	public Node deleteMin(Node x) {
		if (x == null) return null;
		if (x.left == null)
			return x.right;
		else
			x.left = deleteMin(x.left);
		
		return x;
	}

	public Node min(Node x) {
		if (x == null) return null;
		if(x.left == null) 
			return x;
		else
			return min(x.left);
	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null) return 0;
		return x.count;
	}

	@Override
	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null)
			return null;
		else
			return x.key;
	}
	private Node floor(Node x, Key key) {
		if(x == null) return null;
		
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return floor(x.left, key);
		if (cmp == 0)
			return x;
		
		Node t = floor(x.right, key);
		if (t!= null)
			return t;
		else
			return x;
	}

	@Override
	// How many keys  < k
	public int rank(Key key) {
		return rank(root, key);
	}
	
	public int rank(Node x, Key key) {
		if(x == null) return 0;

		int cmp = key.compareTo(x.key);

		if (cmp < 0)
			return rank(x.left, key);
		else if (cmp > 0)
			return 1 + size(x.left) + rank(x.right, key);
		else
			return size(x.left);
	}
}
