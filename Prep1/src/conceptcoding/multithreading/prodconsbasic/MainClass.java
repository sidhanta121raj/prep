package conceptcoding.multithreading.prodconsbasic;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("Main method started");
		SharedResource res = new SharedResource();
		Thread producer = new Thread(new ProduceTask(res));
		Thread consumer = new Thread(new ConsumeTask(res));
		
		producer.start();
		consumer.start();
		
		System.out.println("Main method completed");
	}	

}
