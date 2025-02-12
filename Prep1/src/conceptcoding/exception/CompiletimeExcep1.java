package conceptcoding.exception;

public class CompiletimeExcep1 {

	public static void main(String[] args) throws ClassNotFoundException{
		CompiletimeExcep1 ce = new CompiletimeExcep1();
		ce.method1();

	}
	
	private void method1() throws ClassNotFoundException{
		throw new ClassNotFoundException();
		
	}

}
