package conceptcoding.exception;

public class CompiletimeExcep2 {

	public static void main(String[] args){
		CompiletimeExcep2 ce = new CompiletimeExcep2();
		ce.method1();

	}
	
	private void method1(){
		try {
			throw new ClassNotFoundException();
		}catch(ClassNotFoundException e) {
			
		}
		
	}

}
