package conceptcoding.exception;

import java.io.FileNotFoundException;

public class ExcepHandling3 {

	public static void main(String[] args) throws ClassNotFoundException {//Exception thrown
		try {
			method1("B");
		}
		finally{//finally block can be there without catch also
			//But it won't catch the exception, so the method has to throw the exception to it's caller
			System.out.println("Irrespective of exception occurs or not this will be executed");
		}

	}
	
	private static void method1(String name) throws ClassNotFoundException {
		if(name.equals("A")) {
			throw new ClassNotFoundException();
		}
	}

}
