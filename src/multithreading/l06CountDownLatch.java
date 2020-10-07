package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Runner implements Runnable {
	private CountDownLatch latch;
	
	public Runner(CountDownLatch latch) {
		this.latch =latch;
	}

	@Override
	public void run() {
		System.out.println("Starting runner ...");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		latch.countDown();

		System.out.println("Stopping runner ...");
	}
}

class Waiter implements Runnable {
	private CountDownLatch latch;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Starting waiter ...");

		try {
			latch.await();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Stopping waiter ...");
	}
}

public class l06CountDownLatch {
	
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService es = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i < 3; i++)
			es.submit(new Runner(latch));

		for (int i = 0; i < 3; i++)
			es.submit(new Waiter(latch));
		
		es.shutdown();
	}

}
