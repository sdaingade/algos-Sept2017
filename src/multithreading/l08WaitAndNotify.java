package multithreading;

import java.util.Scanner;

 class Producer1 implements Runnable {
	private Object lock;

	public Producer1(Object lock) {
		this.lock = lock;
	}

	public void run() {
		synchronized(lock) { //acquire lock
			System.out.println("Producer thread running...");
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Producer thread resumed...");
		}
	}
}

class Consumer1 implements Runnable {
	private Object lock;

	public Consumer1(Object lock) {
		this.lock = lock;
	}

	public void run(){
		Scanner scanner = new Scanner(System.in);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		synchronized(lock) {
			System.out.println("Waiting for return key...");
			scanner.nextLine();
			System.out.println("Return key pressed...");
			lock.notify();

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Producer will not wake up untill lock is released
			System.out.println("Consumer about to give up lock ...");
		}
	}
}

public class l08WaitAndNotify {

	public static void main(String[] args) {
		
		Object lock = new Object();
		
		Thread t1 = new Thread(new Producer1(lock));
		Thread t2 = new Thread(new Consumer1(lock));
		
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
