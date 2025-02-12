package conceptcoding.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListExample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println(list);
		
		
		list.add(2, 30);
		
		System.out.println(list);
		
		list.add(2, 20);
		list.add(3, 30);
		list.add(4, 40);
		
		System.out.println(list);
		
		List<Integer> list2 = new ArrayList<>();
		
		list2.add(3);
		list2.add(4);
		list2.add(5);
		
		System.out.println(list2);
		
		list.addAll(2, list2);
		
		System.out.println(list);
		
		list.replaceAll((t)->10*t);
		
		System.out.println(list);
		
		list.sort((a, b) -> a-b);
		
		System.out.println(list);
		
		System.out.println(list.get(3));
		
		System.out.println(list.set(3, 40));
		
		System.out.println(list);
		
		list.remove(3);
		
		System.out.println(list);
		
		
		ListIterator<Integer>  lit = list.listIterator(list.size());
		
		while(lit.hasPrevious()) {
			int val = lit.previous();
			System.out.println("Traversing Backward- Value: "+val+" nextIndex: "+lit.nextIndex()
			+" pvsIndex: "+lit.previousIndex());
			
			if(val == 50) {
				lit.set(100);
			}
		}
		
		System.out.println("After Set"+ list);
		
		
		while(lit.hasNext()) {
			int val = lit.next();
			System.out.println("Traversing Forward- Value: "+val+" nextIndex: "+lit.nextIndex()
			+" pvsIndex: "+lit.previousIndex());
			
			if(val == 40) {
				lit.add(50);
			}
		}
		
		System.out.println("After Set"+ list);
		
		List<Integer> subList = list.subList(0, 7);
		
		System.out.println(subList);
		
		subList.add(29);
		
		System.out.println(subList);
		System.out.println(list);
	}

}
