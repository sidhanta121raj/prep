package conceptcoding.collections.queue.compare;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeEx1 {

	public static void main(String[] args) {
		Deque<Integer> arrDeque = new ArrayDeque<>();
		
		arrDeque.add(1);
		arrDeque.add(5);
		arrDeque.add(10);
		arrDeque.add(20);
		
		int element = arrDeque.removeLast();
		System.out.println(element);
		
		arrDeque.addLast(10);
		arrDeque.addLast(50);
		arrDeque.addLast(100);
		
		System.out.println(arrDeque);
		
		int element2 = arrDeque.removeFirst();
		System.out.println(element2);
		
		System.out.println(arrDeque);

	}

}
