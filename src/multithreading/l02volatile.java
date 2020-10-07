package multithreading;

import java.util.*;

class Proc1 extends Thread {

	private volatile boolean running = true;
	@Override
	public void run() {
		while(running) {
			System.out.println("Hello");

			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		running = false;
	}
}

public class l02volatile {

	public static void main(String[] args) {
		Proc1 p = new Proc1();
		p.start();
		
		System.out.println("Press return to stop....");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		p.shutdown(); //not part of Thread class
	}

}
