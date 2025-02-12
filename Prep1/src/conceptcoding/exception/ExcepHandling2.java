package conceptcoding.exception;

import java.io.FileNotFoundException;

public class ExcepHandling2 {

	public static void main(String[] args) {
		try {
			method1("B");
		}
		catch(InterruptedException e1) {
			
		}
		catch(ClassNotFoundException e2) {
			
		}
		finally{
			System.out.println("Irrespective of exception occurs or not this will be executed");
		}

	}
	
	private static void method1(String name) throws InterruptedException, ClassNotFoundException {
		if(name.equals("A")) {
			throw new ClassNotFoundException();
		}else {
			throw new InterruptedException();
		}
	}

}
