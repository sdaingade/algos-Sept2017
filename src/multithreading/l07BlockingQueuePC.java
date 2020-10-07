package multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	private BlockingQueue<Integer> queue;

/*
 * https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/BlockingQueue.html
 * 
	                Throws exception 	Special value 	Blocks 	            Times out
    Insert 	    add(e) 	                    offer(e)  	        put(e) 	            offer(e, time, unit)
    Remove 	remove() 	            poll() 	            take() 	            poll(time, unit)
    Examine 	element()           	    peek() 	            not applicable 	not applicable
    
*/
	
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		Random r = new Random();
		
		while(true) {
			try {
				queue.put(r.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	private BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		
		while(true) {
			try {
				int value = queue.take();
				
				Thread.sleep(1000);
				
				System.out.println("Taken value:" + value + ", queue size:" + queue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class l07BlockingQueuePC {
	
	public static void main(String[] args) {
	
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
		
		Thread t1 = new Thread(new Producer(queue));
		Thread t2 = new Thread(new Consumer(queue));
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
