package conceptcoding.multithreading.locks;

public class SemaphoreMainClass {

	public static void main(String[] args) {
		
		Resource5 res1 = new Resource5();
		Resource5 res2 = new Resource5();
		
		
		Thread t1 = new Thread(()->{
			res1.produce();
		});
		
		Thread t2 = new Thread(()->{
			res1.produce();
		});
		
		Thread t3 = new Thread(()->{
			res1.produce();
		});
		
		Thread t4 = new Thread(()->{
			res2.produce();
		});
		
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
