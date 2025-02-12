package conceptcoding.multithreading.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReadWriteMainClass {

	public static void main(String[] args) {
		
		ReentrantLock lock = new ReentrantLock();
		
		Resource1 res1 = new Resource1();
		Resource1 res2 = new Resource1();
		
		Thread t1 = new Thread(()->{
			res1.produce(lock);
		});
		
		Thread t2 = new Thread(()->{
			res1.produce(lock);
		});
		
		Thread t3 = new Thread(()->{
			res2.produce(lock);
		});
		
		Thread t4 = new Thread(()->{
			res2.produce(lock);
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
