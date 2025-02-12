package conceptcoding.concurrency.completablefuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletableFutureEx1 {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, 
				new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
		
		CompletableFuture<String> async = CompletableFuture.supplyAsync(()-> {
			return "Task complted";
			}, executor);
		
		try {
			System.out.println(async.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		CompletableFuture<String> async1 = CompletableFuture.supplyAsync(()-> {
			System.out.println("Thread name which runs SupplyAsync "+Thread.currentThread().getName());
			return "Concept and ";
			}, executor).thenApply((val) -> {
				System.out.println("Thread name which runs thenApply "+Thread.currentThread().getName());
				return val+ "Coding";
			});
		
		try {
			System.out.println(async1.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CompletableFuture<String> async2 = CompletableFuture.supplyAsync(()->{
			System.out.println("Thread name which runs Supply Async "+Thread.currentThread().getName());
			return "Concept and ";
		}, executor).thenApplyAsync((val)->{
			System.out.println("Thread name which runs then Apply Async "+Thread.currentThread().getName());
			return val + "Coding";
		});
		
		System.out.println("Thread name after CF "+Thread.currentThread().getName());
		try {
			System.out.println(async2.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		CompletableFuture<String> async3 = CompletableFuture.supplyAsync(()->{
			System.out.println("Thread name which runs SupplyAsync "+Thread.currentThread().getName());
			return "Concept and ";
		}, executor).thenCompose((val)->{
			return CompletableFuture.supplyAsync(()->{
				System.out.println("Thread name which runs thenCompose "+Thread.currentThread().getName());
				return val + "Coding";
				});
		});
		

		try {
			System.out.println(async3.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
		CompletableFuture<Void> async4 = CompletableFuture.supplyAsync(()->{
			System.out.println("Thread name which runs SupplyAsync "+Thread.currentThread().getName());
			return "Concept and ";
		}, executor)
				.thenAccept((val)-> {
					System.out.println("All stages completed");
					//return val+ "coding"; 
				});
		
		try {
			System.out.println(async4.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
		CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(()->{
			return 10;
		});
		
		CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()->{
			return "K";
		});
		
		CompletableFuture<String> combined = cf1.thenCombine(cf2, (a, b)->a+b);
		
		try {
			System.out.println(combined.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executor.shutdown();
		
	}
	
}
