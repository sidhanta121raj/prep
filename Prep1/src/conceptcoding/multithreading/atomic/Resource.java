package conceptcoding.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Resource {
//	private int counter;
	
//	public void increment() {//Consistency issue
//		counter++;
//	}
	
//	public synchronized void increment() {//solution 1
//		counter++;
//	}
	
	private AtomicInteger counter = new AtomicInteger(0);//solution 2
	public void increment() {
		counter.incrementAndGet();
	}
	
	
	public int get() {
		return counter.get();
	}

}
