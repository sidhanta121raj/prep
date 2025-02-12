package conceptcoding.multithreading.monitorlock;

public class MainClass {

	public static void main(String[] args) {
		Resource1 res = new Resource1();
		Resource1 res1 = new Resource1();
		
		Thread t1 = new Thread(() -> res.task1());
		Thread t2 = new Thread(() -> res.task2());
		//Thread t3 = new Thread(() -> res.task3());
		Thread t4 = new Thread(() -> res.task1());
		Thread t5 = new Thread(() -> res.task2());
		//Thread t6 = new Thread(() -> res.task3());
		
		Thread t11 = new Thread(() -> res1.task1());
		
		t1.start();
		t11.start();
		//t2.start();
		//t3.start();
		//t4.start();
		//t5.start();
		//t6.start();

	}

}
