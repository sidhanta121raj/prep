package conceptcoding.multithreading.locks;

import java.util.concurrent.locks.ReentrantLock;

public class Resource1 {
	boolean isAvailable = false;
	
	
	public void produce(ReentrantLock lock) {
		
		try {
			lock.lock();
			System.out.println("Lock acquired by: "+Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
			System.out.println("Lock released by: "+Thread.currentThread().getName());
		}
	}

}
