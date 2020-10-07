package algos.impl;

import algos.iface.Node;
import algos.iface.Queue;

public class LinkedListQueue<T> implements Queue<T>{
	private Node<T> first = null;
	private Node<T> last = null;

	@Override
	public void enqueue(T item) {
		Node<T> newLast = new Node<T>(item, null);
		if (last == null) {
			first = newLast;
			last = newLast;
		} else {
			last.setNext(newLast);
			last = newLast;
		}
	}

	@Override
	public T dequeue() throws Exception {
		if (first == null)
			throw new Exception("Empty Queue");
		T item = first.getItem();
		first = first.getNext();

		if (first == null)
			last = null;

		return item;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

}
