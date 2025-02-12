package conceptcoding.multithreading.monitorlock;

public class Resource1 {
	
	public synchronized void task1() {
		
		try {
			System.out.println("Task 1-Started: "+Thread.currentThread().getName());
			Thread.sleep(10000);
			System.out.println("Task 1-Completed: "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void task2() {
		System.out.println("Task2-BeforeSynchronized-Started: "+Thread.currentThread().getName());
		synchronized (this) {
			System.out.println("Task2-AfterSynchronized-Completed: "+Thread.currentThread().getName());
		}
		
	}

	public void task3() {
		System.out.println("Task3-Started: "+Thread.currentThread().getName());
		System.out.println("Task3-Complted: "+Thread.currentThread().getName());
	}

}
