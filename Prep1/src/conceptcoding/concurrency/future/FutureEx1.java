package conceptcoding.concurrency.future;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureEx1 {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
				new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(),
				new ThreadPoolExecutor.AbortPolicy());

		Future<?> future = executor.submit(() -> {
			try {
				Thread.sleep(7000);
				System.out.println("This is the Task which thread will execute");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		});

		System.out.println("Is done? "+future.isDone());
		
		try {
			future.get(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Is Done: "+future.isDone());
		System.out.println("Is Done: "+future.isCancelled());

	}

}
