package conceptcoding.multithreading.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantMainClass {

	public static void main(String[] args) {
		
		ReadWriteLock lock = new ReentrantReadWriteLock();
		
		Resource2 res1 = new Resource2();
		Resource2 res2 = new Resource2();
		
		
		Thread t1 = new Thread(()->{
			res1.produce(lock);
		});
		
		Thread t2 = new Thread(()->{
			res1.produce(lock);
		});
		
		Thread t3 = new Thread(()->{
			res2.consume(lock);
		});
		
		
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
