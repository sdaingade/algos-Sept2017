package algos.impl;

import java.util.Iterator;

import algos.iface.Node;
import algos.iface.Stack;

public class LinkedListStack<T> implements Stack<T>, Iterable<T> {
	private Node<T> first = null;
	
	private class ListIterator implements Iterator<T> {

		private Node<T> current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (current == null)
				throw new RuntimeException("End of iterator");

			T item = current.getItem();
			current = current.getNext();
			return item;
		}

		@Override
		public void remove(){
			throw new RuntimeException("Not Supported");
		}

	}

	@Override
	public synchronized void push(T item) throws Exception {
		Node<T> newNode = new Node<T>(item, first);
        first = newNode;
	}

	@Override
	public synchronized T pop() throws Exception {
		if (first == null)
			throw new Exception("Stack is empty!");

		Node<T> oldFirst = first;
		first = first.getNext();
		return oldFirst.getItem();
	}

	@Override
	public synchronized boolean isEmpty() throws Exception {
		return first == null;
	}

	@Override
	public synchronized int size() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}

}
