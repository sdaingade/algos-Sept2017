package multithreading;

public class l01CreatingThreads {
	public Integer count = 0;
	
	public synchronized void increment() {
		count++;
	}

	public static void main(String[] args) {
		l01CreatingThreads t = new l01CreatingThreads();
		t.doWork();
	}
	
	public void doWork(){
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i < 10000; i++) {
					increment();
					/*
					try {
						Thread.sleep(100);
					} catch(InterruptedException e) {
						e.printStackTrace();
					}*/
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i < 10000; i++) {
					increment();
					/*
					try {
						Thread.sleep(100);
					} catch(InterruptedException e) {
						e.printStackTrace();
					}*/
				}

			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Count: " + count);
	}
}
