package conceptcoding.multithreading.prodconsbasic;

public class SharedResource {
	
	boolean itemAvailable = false;
	
	public synchronized void addItem() {
		itemAvailable = true;
		System.out.println("Item Added by: "+Thread.currentThread().getName());
		notifyAll();
	}
	
	public synchronized void consumeItem() {
		System.out.println("Consume Item called by: "+Thread.currentThread().getName());
		
		while(!itemAvailable) {
			try {
				System.out.println("Thread: "+Thread.currentThread().getName()+" is waiting now");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Item Consumed by: "+Thread.currentThread().getName());
		itemAvailable = false;
		
	}

}
