package multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class l13FutureCallable {
	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		Future<Integer> timeMilli = es.submit(new Callable<Integer>(){

			@Override
			public Integer call() throws Exception {
				Random r = new Random();
				int waitTime = 0;
				System.out.println("Starting...");
				try {
					waitTime = r.nextInt(5000);
					if (waitTime > 2000)
						throw new RuntimeException("Sleeping for too long!");
					Thread.sleep(waitTime);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Stopping...");
				return waitTime;
			}

		});

		try {
			System.out.println("timeMillis: " + timeMilli.get());
			es.shutdown();
			es.awaitTermination(1, TimeUnit.MINUTES);
		}catch(Exception e) {
			System.out.println("Cause: " + e.getCause());
			e.printStackTrace();
		}
	}
}
