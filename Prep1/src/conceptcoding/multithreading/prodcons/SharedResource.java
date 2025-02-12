package conceptcoding.multithreading.prodcons;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
	
	private Queue<Integer> buffer;
	private int bufferSize;
	
	public SharedResource(int bufferSize) {
		this.buffer= new LinkedList<Integer>();
		this.bufferSize = bufferSize;
	}
	
	public synchronized void produce(int item) {
		while(buffer.size() == bufferSize) {
			try {
				System.out.println("Buffer is full, waiting for consumer to consume");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buffer.add(item);
		System.out.println("produced:"+item);
		notify();
	}
	
	public synchronized int consume() {
		while(buffer.isEmpty()) {
			try {
				System.out.println("Buffer is empty, waiting for producer to produce");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int item = buffer.poll();
		System.out.println("consumed "+item);
		notify();
		return item;
	}

}
