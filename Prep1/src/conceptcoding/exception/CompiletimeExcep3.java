package conceptcoding.exception;

public class CompiletimeExcep3 {

	public static void main(String[] args){
		CompiletimeExcep3 ce = new CompiletimeExcep3();
		try {
			ce.method1();
		}catch(ClassNotFoundException e) {
			
		}

	}
	
	private void method1() throws ClassNotFoundException{
		
			throw new ClassNotFoundException();
		
		
	}

}
