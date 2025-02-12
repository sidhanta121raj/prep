package conceptcoding.multithreading.threadcreate;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("Current Thread Running: "+Thread.currentThread().getName());
		
		MyThreadFromThread thread1 = new MyThreadFromThread();
		thread1.start();
		
		
		MyThreadFromRunnable myThreadFromRunnable = new MyThreadFromRunnable();
		Thread  thread2 = new Thread(myThreadFromRunnable);
		thread2.start();

	}

}
