package conceptcoding.collections.queue.compare;

public class Car {
	String carName;
	String carType;
	
	Car(String name, String type){
		this.carName = name;
		this.carType = type;
	}

	@Override
	public String toString() {
		return "Car [carName=" + carName + ", carType=" + carType + "]";
	}

}
