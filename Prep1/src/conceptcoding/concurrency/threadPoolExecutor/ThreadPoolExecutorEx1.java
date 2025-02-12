package conceptcoding.concurrency.threadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorEx1 {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 1, TimeUnit.HOURS, 
				new ArrayBlockingQueue<Runnable>(2), new CustomThreadFactory(), new CustomRejectHandler());
		
		executor.allowCoreThreadTimeOut(true);
		
		for (int i=0; i<7; i++) {
			executor.submit(()->{
				try {
					Thread.sleep(5000);
					System.out.println("Thread Name: "+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
		}
		
		executor.shutdown();

	}

}
