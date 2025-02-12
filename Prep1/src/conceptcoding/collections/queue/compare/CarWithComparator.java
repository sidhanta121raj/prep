package conceptcoding.collections.queue.compare;

import java.util.Comparator;

public class CarWithComparator implements Comparator<CarWithComparator> {
	String carName;
	String carType;
	CarWithComparator(){
		
	}
	CarWithComparator(String name, String type){
		this.carName = name;
		this.carType = type;
	}
	
	@Override
	public int compare(CarWithComparator o1, CarWithComparator o2) {
		return o1.carType.compareTo(o2.carType);
	}

	@Override
	public String toString() {
		return "Car [carName=" + carName + ", carType=" + carType + "]";
	}

	

}
