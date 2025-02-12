package conceptcoding.collections.queue.compare;



public class CarWithComparable implements Comparable<CarWithComparable> {
	String carName;
	String carType;
	CarWithComparable(){
		
	}
	CarWithComparable(String name, String type){
		this.carName = name;
		this.carType = type;
	}
	
	@Override
	public int compareTo(CarWithComparable o) {
		// TODO Auto-generated method stub
		return this.carName.compareTo(o.carName);
	}
	
	Integer in = 10;

	@Override
	public String toString() {
		return "Car [carName=" + carName + ", carType=" + carType + "]";
	}
	

	

}
