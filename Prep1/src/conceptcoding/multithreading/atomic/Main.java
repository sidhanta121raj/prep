package conceptcoding.multithreading.atomic;

public class Main {

	public static void main(String[] args) {
		Resource res = new Resource();
		
		Thread t1 = new Thread(()->{
			for(int i=0; i<200; i++) {
				res.increment();
			}
		});
		
		Thread t2 = new Thread(()->{
			for(int i=0; i<200; i++) {
				res.increment();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println(res.get());

	}

}
