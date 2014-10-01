package threads;

import java.util.concurrent.CountDownLatch;

public class MultiThreadingPrintingBusyLoop {
	public static void main(String[] args) throws InterruptedException {
		Thread threads[] = new Thread[5];
		CountDownLatch latch = new CountDownLatch(5);
		for (int i = 0; i < threads.length; i++) {
			final int current = i;

			threads[i] = new Thread() {
				public void run() {
					System.out.println(current);
					latch.countDown();
				}
			};
			threads[i].start();
		}
		latch.await();

		System.out.println("Finished");
	}
}
