package conceptcoding.concurrency.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallableEx1 {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

		Future<?> future = executor.submit(() -> {
			System.out.println("Task1 with Runnable");
		});

		try {
			Object object = future.get();
			System.out.println(object == null);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		List<Integer> output = new ArrayList<>();
		Future<List<Integer>> future2 = executor.submit(()->{
			output.add(100);
			System.out.println("");
		}, output);
		
		try {
			List<Integer> listObject = future2.get();
			System.out.println(listObject.get(0));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
		Future<List<Integer>> future3 = executor.submit(()->{
			System.out.println("Task 3 with Callable");
			List<Integer> output2 = new ArrayList<>();
			output2.add(200);
			return output2;
		});
		
		try {
			List<Integer> listObject = future3.get();
			System.out.println(listObject.get(0));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("Is Done: " + future.isDone());
		System.out.println("Is Done: " + future.isCancelled());
		
		executor.shutdown();

	}

}
