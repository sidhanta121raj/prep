package conceptcoding.multithreading.locks;

import java.util.concurrent.locks.StampedLock;

public class Resource4 {
	int a = 10;
	StampedLock lock = new StampedLock();
	
	
	public void produce() {
		long stamp = lock.tryOptimisticRead();
		try {
			System.out.println("ReadLock acquired by: "+Thread.currentThread().getName());
			a = 11;
			Thread.sleep(5000l);
			if(lock.validate(stamp)) {
				System.out.println("Updated value successfully");
			}else {
				System.out.println("Rollback");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void consume() {
		long stamp = lock.writeLock();
		System.out.println("WriteLock acquired by: "+Thread.currentThread().getName());
		try {
			System.out.println("Performing work");
			a = 9;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlockWrite(stamp);
			System.out.println("WriteLock released by: "+Thread.currentThread().getName());
		}
	}

}
