package conceptcoding.concurrency.threadPoolExecutor;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		return t;
	}

}
