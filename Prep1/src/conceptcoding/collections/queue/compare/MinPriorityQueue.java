package conceptcoding.collections.queue.compare;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinPriorityQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(2);
		queue.add(5);
		queue.add(8);
		queue.add(1);
		
		queue.forEach((q)->System.out.print(q+" "));
		System.out.println();
		
		while(! queue.isEmpty()) {
			int q = queue.poll();
			System.out.println(q);
		}

	}

}
