package conceptcoding.exception;

import java.io.FileNotFoundException;

public class ExcepHandling4 {

	public static void main(String[] args) {//No Exception thrown
		try {
			method1("B");
		}
		finally{//finally block can be there without catch also
			//But it won't catch the exception, so the method has to throw the exception to it's caller
			//But Runtime or Checked exception need not to be handled nor needed to be thrown
			System.out.println("Irrespective of exception occurs or not this will be executed");
		}

	}
	
	private static void method1(String name) throws NullPointerException {//This is also optional but good to handle or throw Runtime exception
		if(name.equals("A")) {
			throw new NullPointerException();
		}
	}

}
