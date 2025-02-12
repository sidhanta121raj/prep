package conceptcoding.collections.queue.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorEx5 {

	public static void main(String[] args) {
		List<CarWithComparator> carAr = new ArrayList<>();
		
		carAr.add(new CarWithComparator("Hatchback", "CNG"));
		carAr.add(new CarWithComparator("Sedan", "Petrol"));
		carAr.add(new CarWithComparator("Suv", "Diesel"));
		Collections.sort(carAr, new CarWithComparator());
		
		for(CarWithComparator car: carAr) {
			System.out.println(car);
		}
		

	}

}
