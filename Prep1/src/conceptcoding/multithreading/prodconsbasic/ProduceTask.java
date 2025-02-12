package conceptcoding.multithreading.prodconsbasic;

public class ProduceTask implements Runnable{
	
	SharedResource res;
	
	ProduceTask(SharedResource res){
		this.res = res;
	}

	@Override
	public void run() {
		System.out.println("Producer Thread: "+Thread.currentThread().getName());
		
		try {
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.addItem();
		
	}

}
