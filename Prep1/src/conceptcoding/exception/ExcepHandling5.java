package conceptcoding.exception;

import java.io.FileNotFoundException;

public class ExcepHandling5 {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			method1("B");
		}
		catch(ClassNotFoundException e1) {
			throw e1;
		}
		

	}
	
	private static void method1(String name) throws ClassNotFoundException {
		if(name.equals("A")) {
			throw new ClassNotFoundException();
		}
	}

}
