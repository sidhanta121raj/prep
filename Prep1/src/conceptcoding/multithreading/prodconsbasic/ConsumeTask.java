package conceptcoding.multithreading.prodconsbasic;

public class ConsumeTask implements Runnable{
	
	SharedResource res;
	
	ConsumeTask(SharedResource res){
		this.res = res;
	}

	@Override
	public void run() {
		System.out.println("Consumer Thread: "+Thread.currentThread().getName());
		res.consumeItem();;
		
	}

}
