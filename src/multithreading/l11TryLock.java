package multithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
	private int balance = 10000;

	public void deposit(int amount) {
		balance += amount;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}

	public int getBalance() {
		return balance;
	}
	
	public static void transfer(Account from, Account to, int amount) {
		from.withdraw(amount);
		to.deposit(amount);
	}
}

public class l11TryLock {
	
	private Account acct1 = new Account();
	private Account acct2 = new Account();
	Random r = new Random();
	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();

	public void method1() {
		Random r = new Random();

		for (int i = 0; i < 10000; i++) {
			acquireLock(lock1, lock2);
			System.out.println("Acquired both locks. Thread1 i= " + i);
			try {
				Account.transfer(acct1, acct2, r.nextInt(100));
			}finally {
				lock1.unlock();
				lock2.unlock();
			}
			System.out.println("Relinquished both locks. Thread1 i= " + i);

			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void method2() {
		Random r = new Random();

		for (int i = 0; i < 10000; i++) {
			acquireLock(lock2, lock1);
			System.out.println("Acquired both locks. Thread2 i= " + i);
			try {
				Account.transfer(acct2, acct1, r.nextInt(100));
			}finally {
				lock2.unlock();
				lock1.unlock();
			}
			System.out.println("Relinquished both locks. Thread2 i= " + i);

			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void acquireLock(Lock lock1, Lock lock2) {
		while(true) {
			boolean getLock1 = false;
			boolean getLock2 = false;
			
			try {
				getLock1 = lock1.tryLock();
				getLock2 = lock2.tryLock();
			} finally {
				if(getLock1 && getLock2)
					return;
				if(getLock1)
					lock1.unlock();
				if(getLock2)
					lock2.unlock();
			}
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void printBalance() {
		System.out.println("Account 1 balance: " + acct1.getBalance());
		System.out.println("Account 2 balance: " + acct2.getBalance());
		System.out.println("Total balance: " + (acct1.getBalance() + acct2.getBalance()));
	}

	public static void main(String[] args) {
		final l11TryLock tl = new l11TryLock();
		
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				tl.method1();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				tl.method2();
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
		tl.printBalance();
	}

}


