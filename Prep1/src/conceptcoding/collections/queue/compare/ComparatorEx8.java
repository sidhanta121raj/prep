package conceptcoding.collections.queue.compare;

import java.util.Arrays;

public class ComparatorEx8 {

	public static void main(String[] args) {
		CarWithComparable [] carAr = new CarWithComparable[3];
		
		carAr[0] = new CarWithComparable("Suv", "Diesel");
		carAr[1] = new CarWithComparable("Hatchback", "CNG");
		carAr[2] = new CarWithComparable("Sedan", "Petrol");
		
		Arrays.sort(carAr);
		
		for(CarWithComparable car: carAr) {
			System.out.println(car);
		}
		

	}

}
