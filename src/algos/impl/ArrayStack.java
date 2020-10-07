package algos.impl;

import java.lang.reflect.Array;

import algos.iface.Stack;

public class ArrayStack<T> implements Stack<T>{
	private int capacity = 1;
	private int ptr = 0;
	private T[] elems = null;

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		elems = (T[]) new Object[capacity]; 
	}

	@Override
	public synchronized void push(T item) throws Exception {
		if (ptr >= capacity)
			resize(capacity * 2);

		elems[ptr] = item;
		ptr++;
	}

	@Override
	public synchronized T pop() throws Exception {
		if (ptr == 0)
			throw new Exception("Stack is empty");

		ptr--;
		T item = elems[ptr];
		elems[ptr] = null;
		
		if (ptr <= this.capacity/4)
			resize(capacity/2);

		return item;
	}

	@Override
	public synchronized boolean isEmpty() throws Exception {
		return ptr == 0;
	}

	@Override
	public int size() throws Exception {
		return 0;
	}

	@SuppressWarnings("unchecked")
	private synchronized void resize(int newCapacity) {
		T[] newElems = (T[])new Object[newCapacity];

		for (int i =0; i< this.capacity; i++)
			newElems[i] = elems[i];

		this.capacity = newCapacity;
		elems = newElems;
	}

}
