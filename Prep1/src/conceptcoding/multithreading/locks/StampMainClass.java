package conceptcoding.multithreading.locks;

import java.util.concurrent.locks.StampedLock;

public class StampMainClass {

	public static void main(String[] args) {
		
		StampedLock lock = new StampedLock();
		
		Resource3 res1 = new Resource3();
		Resource3 res2 = new Resource3();
		
		Thread t1 = new Thread(()->{
			res1.produce(lock);
		});
		
		Thread t2 = new Thread(()->{
			res1.produce(lock);
		});
		
		Thread t3 = new Thread(()->{
			res2.consume(lock);
		});
		
		Thread t4 = new Thread(()->{
			res2.consume(lock);
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
