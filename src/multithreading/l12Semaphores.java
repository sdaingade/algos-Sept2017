package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;



class Connection {
	private int connectionCount = 0;
	private Semaphore sem = new Semaphore(10);
	private static Connection connection = new Connection(); 
	
	private Connection() {
	}
	
	public static Connection getInstance() {
		return connection;
	}

	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			synchronized(this) {
				connectionCount ++;
			}
			System.out.println("Current connections: " + connectionCount);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			sem.release();
			synchronized(this) {
				connectionCount --;
			}
		}
	}
}
public class l12Semaphores {

	public static void main(String[] args) {

		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 200; i++) {
			es.submit(new Runnable() {
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}
		
		es.shutdown();
		try {
			es.awaitTermination(1, TimeUnit.DAYS);
		}catch(InterruptedException e) {
			
		}
	}
}
