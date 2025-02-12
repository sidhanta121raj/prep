package conceptcoding.multithreading.prodcons;

public class MainClass {

	public static void main(String[] args) {
		SharedResource res = new SharedResource(3);
		Thread producer = new Thread(() -> {
			for (int i = 1; i <= 6; i++) {
				res.produce(i);
			}

		}

		);

		Thread consumer = new Thread(() -> {
			for (int i = 1; i <= 6; i++) {
				res.consume();
			}
		});
		
		producer.start();
		consumer.start();
	}
}
