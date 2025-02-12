package conceptcoding.multithreading.prodconsCustomLock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
	
	private Queue<Integer> buffer;
	private int bufferSize;
	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	
	public SharedResource(int bufferSize) {
		this.buffer= new LinkedList<Integer>();
		this.bufferSize = bufferSize;
	}
	
	public void produce(int item) {
		try {
			lock.lock();
			while(buffer.size() == bufferSize) {
				try {
					System.out.println("Buffer is full, waiting for consumer to consume");
					condition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			buffer.add(item);
			System.out.println("produced:"+item);
			condition.signal();
		}
		finally {
			lock.unlock();
		}
	}
	
	public int consume() {
		try {
			lock.lock();
			while(buffer.isEmpty()) {
				try {
					System.out.println("Buffer is empty, waiting for producer to produce");
					condition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int item = buffer.poll();
			System.out.println("consumed "+item);
			condition.signal();
			return item;
		}finally {
			lock.unlock();
		}
		
	}

}
