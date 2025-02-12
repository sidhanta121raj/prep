package conceptcoding.multithreading.locks;

import java.util.concurrent.Semaphore;

public class Resource5 {
	boolean isAvailable = false;
	Semaphore lock = new Semaphore(2);
	
	
	public void produce() {
		
		try {
			lock.acquire();
			System.out.println("Lock acquired by: "+Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.release();
			System.out.println("Lock released by: "+Thread.currentThread().getName());
		}
	}

}
