package collections;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class L09Queues {
	public static void main(String[] args) {
		//This is a bounded queue
		Queue<Integer> q = new ArrayBlockingQueue<Integer>(3);
		// IMP! If you want an unbounded queue you can use a LinkedList
/*

		            Throws exception 	Returns special value
	Insert 	    add(e) 	                    offer(e)
	Remove 	remove() 	            poll()
	Examine 	element()            	peek()
*/		
		
		// add(), remove(), element() throw exception
		
		// throws NoSuchElementException
		//System.out.println("Head of queue is :" + q.element());
		
		q.add(1);
		q.add(3);
		q.add(2);
		
		System.out.println("Head of queue is :" + q.element());

		try {
			q.add(1); //queue length =3 (max)
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		
		for(Integer item:q)
			System.out.println("Queue Item: " + item);
		
		System.out.println("Removed :" + q.remove());
		System.out.println("Removed :" + q.remove());
		System.out.println("Removed :" + q.remove());

		try {
			System.out.println("Removed :" + q.remove());
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		// offer(), poll(), peak() return special values like null or false
		Queue<Integer> q2 = new ArrayBlockingQueue<Integer>(2);
		
		System.out.println("Queue2 peek: " + q2.peek());

		q2.offer(1);
		q2.offer(3);
		q2.offer(2); //Last item does not get added as Queue is of length 2. Also, no exception is thrown.
		
		if(q2.offer(65) == false)
			System.out.println("Could  not add 65 to queue");
		
		for(Integer item:q2)
			System.out.println("Queue Item: " + item);

		System.out.println("Queue 2 poll :" + q2.poll());
		System.out.println("Queue 2 poll :" + q2.poll());
		System.out.println("Queue 2 poll :" + q2.poll());
		if(q2.poll() == null)
			System.out.println("Could not remove from queue");
		
	}
}
