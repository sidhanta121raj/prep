package conceptcoding.collections.queue.compare;

import java.util.Comparator;

public class CarNameComparator implements Comparator<Car>{

	@Override
	public int compare(Car o1, Car o2) {
		// TODO Auto-generated method stub
		return o2.carName.compareTo(o1.carName);
	}

}
