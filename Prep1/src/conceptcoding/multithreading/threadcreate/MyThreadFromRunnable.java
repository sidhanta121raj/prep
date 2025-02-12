package conceptcoding.multithreading.threadcreate;

public class MyThreadFromRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("Code executed by thread: "+Thread.currentThread().getName());
		
	}

}