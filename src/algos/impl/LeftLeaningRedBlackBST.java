package algos.impl;

import java.awt.BufferCapabilities.FlipContents;

import algos.iface.ST;
//import algos.impl.SeperateChainingHashST.Node;

/*
 * Implements a 2-3 tree by splitting a 3node to a tree of size 2 with a read link connecting the nodes
 * 
 * A BST such that
 * 1. No node has two red links connected to it
 * 2. Every path from root to null link has the same number of black links
 * 3. Red links lean left
 */
// java.util.TreeMap and java.util.TreeSet uses Red-Black trees
public class LeftLeaningRedBlackBST <Key extends Comparable<Key>, Value>implements ST<Key, Value> {

	public static final boolean RED = true;

	public static final boolean BLACK = false;

	private class Node{
		private Key key;
		
		private Value value;
		
		private Node left;
		
		private Node right;
		
		private int count;
		
		private boolean color; //Color of parent link
		
		public Node(Key key, Value value, boolean color) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
			this.count = 1;
			this.color = color;
		}
	}
	
	private Node root = null;
	
	private boolean isRed(Node x) {
		if (x == null) return false;
		else return (x.color == RED);
	}

	private int size(Node x) {
		if (x == null) return 0;
		else return x.count;
	}
	
	private Node rotateLeft(Node h) {
		assert isRed(h.right);
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private Node rotateRight(Node h) {
		assert isRed(h.left);
		Node x = h.left;
		x.right = h;
		h.left = x.right;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private void colorFlip(Node h) { //Temporary 4 node in 2-3 tree
		assert !isRed(h);
		assert isRed(h.left);
		assert isRed(h.right);
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	@Override
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	public Node put(Node x, Key key, Value value) {
		if (x == null) return new Node(key, value, RED); //New node always has incoming RED link
		
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, value);
		else if (cmp > 0)
			x.right = put(x.right, key, value);
		else x.value = value;

		x.count = 1 + size(x.left) + size(x.right);

		//------ Additional code for LLRB-BST-------------
		if(isRed(x.right) && !isRed(x.left))
			x = rotateLeft(x);
		
		if(isRed(x.left) && isRed(x.left.left))
			x = rotateRight(x);
		
		if(isRed(x.left) && isRed(x.right))
			colorFlip(x);
		//------ End additional code for LLRB-BST-------------
		return x;
	}

	@Override
	public Value get(Key key) {
		Node x = root;
		
		while(x!= null) {
			int cmp = key.compareTo(x.key);

			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else return x.value;
		}

		return null;
	}

	@Override
	public void delete(Key key) {
		root = delete(root, key);
		
	}
	
	private Node delete(Node x, Key key) {
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
			x.left = t.left;
			x.right = deleteMin(t.right);
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	private Node min(Node x) {
		if (x == null) return null;
		
		if(x.left == null)
			return x;
		else
			return min(x.left);

	}
	
	private Node deleteMin(Node x) {
		if (x == null) return null;
		
		if(x.left != null)
			return deleteMin(x.left);
		else
			return x.right;
	}
	

	@Override
	public boolean contains(Key key) {
		if (get(key) == null) return false;
		else return false;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		if(isEmpty()) return 0;
		else return size(root);
	}

	@Override
	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x != null)
			return x.key;
		return null;
	}

	private Node floor(Node x, Key key) {
		if (x == null) return null;
		
		int cmp = key.compareTo(x.key);
		
		if(cmp < 0)
			return floor(x.left, key);
		else if (cmp == 0)
			return x;
		else {
			Node t = floor(x.right, key);
			if (t == null) return x;
			else return t;
		}
	}

	@Override
	// How many keys  < k
	public int rank(Key key) {
		return 0;
	}

}
