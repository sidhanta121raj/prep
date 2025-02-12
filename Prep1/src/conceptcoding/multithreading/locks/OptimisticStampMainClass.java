package conceptcoding.multithreading.locks;

public class OptimisticStampMainClass {

	public static void main(String[] args) {
		Resource4 res1 = new Resource4();
		
		
		Thread t1 = new Thread(()->{
			res1.produce();
		});
		
		Thread t2 = new Thread(()->{
			res1.consume();
		});
		
		
		
		t1.start();
		//t2.start();
		
	}

}
