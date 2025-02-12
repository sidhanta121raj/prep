package conceptcoding.collections.queue.compare;

import java.util.Arrays;

public class ComparatorEx6 {

	public static void main(String[] args) {
		Car [] carAr = new Car[3];
		
		carAr[0] = new Car("Hatchback", "CNG");
		carAr[1] = new Car("Sedan", "Petrol");
		carAr[2] = new Car("Suv", "Diesel");
		Arrays.sort(carAr, new CarNameComparator());
		
		for(Car car: carAr) {
			System.out.println(car);
		}
		

	}

}
