package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
	private int id = -1;
	
	public Processor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting " + id);
		try{
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed " + id);
	}
}

public class l05ThreadPool {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2); //Two threads will run at one time

		for (int i = 0; i < 5; i++)
			es.submit(new Processor(i));
		
		es.shutdown();
	}

}
