package conceptcoding.multithreading.locks;

import java.util.concurrent.locks.StampedLock;

public class Resource3 {
	boolean isAvailable = false;
	
	
	public void produce(StampedLock lock) {
		long stamp = lock.readLock();
		try {
			System.out.println("ReadLock acquired by: "+Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlockRead(stamp);
			System.out.println("ReadLock released by: "+Thread.currentThread().getName());
		}
	}
	
	public void consume(StampedLock lock) {
		long stamp = lock.writeLock();
		try {
			
			System.out.println("WriteLock acquired by: "+Thread.currentThread().getName());
			isAvailable = false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlockWrite(stamp);
			System.out.println("WriteLock released by: "+Thread.currentThread().getName());
		}
	}

}
