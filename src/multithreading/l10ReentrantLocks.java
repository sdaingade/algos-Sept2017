package multithreading;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class l10ReentrantLocks {
	private int count = 0;
	private ReentrantLock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	public void increment() {
		for(int i = 0; i < 10000; i++)
			count++;
	}
	
	public void method1() {
		lock.lock();
		
		System.out.println("Waiting in Thread 1...");
		try {
			cond.await(); //IMP!!! Not wait() as used with Condition object
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread 1 woken up ...");
		
		try {
			increment();
		} finally {
			lock.unlock();
		}
		
	}

	public void method2() {
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}

		lock.lock();
		System.out.println("Thread 2 acquired lock!");

		System.out.println("Press the return key!");
		new Scanner(System.in).nextLine();
		System.out.println("Return key pressed!");
		cond.signal();; //Lock cannot be gained by other thread before we unlock it
		// After you call signal you have to call unlock(). Just calling signal is not enough
		
		
		//IMP!!! signal() not notify() as used with Condition Obj
		System.out.println("Thread 2 has notified one thread...");

		try {
			increment();
		}finally {
			System.out.println("Thread 2 about to unlock...");
			lock.unlock();
		}

	}
	
	public static void main(String[] args) {

		final l10ReentrantLocks rl = new l10ReentrantLocks();


		Thread t1 = new Thread(new Runnable() {
			public void run() {
				rl.method1();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run(){
				rl.method2();
			}
		});

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
