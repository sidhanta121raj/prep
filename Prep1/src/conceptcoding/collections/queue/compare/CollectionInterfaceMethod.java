package conceptcoding.collections.queue.compare;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CollectionInterfaceMethod {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println("IsEmpty? "+list.isEmpty());
		list.forEach((val)->System.out.print(val+"  "));
		System.out.println();
		
		System.out.println("Size: "+list.size());
		list.forEach((val)->System.out.print(val+"  "));
		System.out.println();
		
		System.out.println("Contains 4? "+list.contains(4));
		list.forEach((val)->System.out.print(val+"  "));
		System.out.println();
		
		System.out.println("Added 4? "+list.add(4));
		list.forEach((val)->System.out.print(val+"  "));
		System.out.println();
		
		System.out.println("Removed: "+list.remove(3));
		list.forEach((val)->System.out.print(val+"  "));
		System.out.println();
		
		System.out.println("Removed 3? "+list.remove(Integer.valueOf(3)));
		list.forEach((val)->System.out.print(val+"  "));
		System.out.println();
		
		Stack<Integer> stack = new Stack<>();
		stack.add(6);
		stack.add(7);
		stack.add(8);
		
		list.addAll(stack);
		System.out.println("List containsAll stack? "+list.containsAll(stack));
		list.forEach((val)->System.out.print(val+"  "));
		System.out.println();
		
		list.remove(Integer.valueOf(7));
		System.out.println("List containsAll stack after removing 7? "+list.containsAll(stack));
		list.forEach((val)->System.out.print(val+"  "));
		System.out.println();
		
		list.removeAll(stack);
		System.out.println("List contains 8 after removeAll stack? "+list.contains(8));
		list.forEach((val)->System.out.print(val+"  "));
		System.out.println();
		
		list.clear();
		System.out.println("IsEmpty After clear? "+list.isEmpty());
		list.forEach((val)->System.out.print(val+"  "));
		System.out.println();
		
		
		
		
	}

}
