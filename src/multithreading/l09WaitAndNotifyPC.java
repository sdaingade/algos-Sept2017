package multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class l09WaitAndNotifyPC {
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private int LIMIT;
	private Object lock = new Object();	

	public l09WaitAndNotifyPC(int limit) {
		this.LIMIT = limit;
	}
	
	public void produce(int toAdd) throws InterruptedException {
		synchronized(lock) {
			while(list.size() == LIMIT) {
				lock.wait();
			}

			list.add(toAdd);
			System.out.println("Added value: " + toAdd + ", list size: " + list.size() );
			lock.notify();

		}
	}

	public int consume() throws InterruptedException {
		synchronized(lock) {
			while(list.size() == 0) {
				lock.wait();
			}

			int removed = list.removeFirst();
			System.out.println("Removed value: " + removed + ", list size: " + list.size()  );
			lock.notify();
			return removed;
		}
	}

	public static void main(String[] args) {
		final l09WaitAndNotifyPC pc = new l09WaitAndNotifyPC(10);

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				Random r = new Random();
				while(true) {
					try {
						pc.produce(r.nextInt(100));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						pc.consume();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
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
