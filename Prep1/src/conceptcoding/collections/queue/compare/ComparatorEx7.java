package conceptcoding.collections.queue.compare;

import java.util.Arrays;

public class ComparatorEx7 {

	public static void main(String[] args) {
		CarWithComparator [] carAr = new CarWithComparator[3];
		
		carAr[0] = new CarWithComparator("Hatchback", "CNG");
		carAr[1] = new CarWithComparator("Sedan", "Petrol");
		carAr[2] = new CarWithComparator("Suv", "Diesel");
		Arrays.sort(carAr, new CarWithComparator());
		
		for(CarWithComparator car: carAr) {
			System.out.println(car);
		}
		

	}

}
