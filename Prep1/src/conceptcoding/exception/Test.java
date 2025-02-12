package conceptcoding.exception;

public class Test {
	
	public static void main(String[] args) {
		try {
			method1();
		} catch (CustomExcep1 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		method2();
		
		try {
			method3();
		} catch (CustomExcep3 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void method1() throws CustomExcep1{//Have to throw or handle since the cusomexception1 is Exception
		throw new CustomExcep1("Exception1");
	}
	
	private static void method2(){//Don't have to throw or handle since the cusomexception2 is RuntimeException
		throw new CustomExcep2("Exception2");
	}
	
	private static void method3() throws CustomExcep3{//Have to throw or handle since the cusomexception3 is a Checked Exception
		throw new CustomExcep3("Exception3");
	}
	
	

}
