package conceptcoding.multithreading.locks;

import java.util.concurrent.locks.ReadWriteLock;

public class Resource2 {
	boolean isAvailable = false;
	
	
	public void produce(ReadWriteLock lock) {
		
		try {
			lock.readLock().lock();;
			System.out.println("ReadLock acquired by: "+Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.readLock().unlock();;
			System.out.println("ReadLock released by: "+Thread.currentThread().getName());
		}
	}
	
	public void consume(ReadWriteLock lock) {
			
			try {
				lock.writeLock().lock();
				System.out.println("WriteLock acquired by: "+Thread.currentThread().getName());
				isAvailable = false;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.writeLock().unlock();;
				System.out.println("WriteLock released by: "+Thread.currentThread().getName());
			}
		}

}
