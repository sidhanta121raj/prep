package conceptcoding.exception;

import java.io.FileNotFoundException;

public class ExcepHandling1 {

	public static void main(String[] args) {
		try {
			method1("B");
		}
		catch(InterruptedException e1) {
			
		}
		catch(ClassNotFoundException e2) {
			
		}
//		catch(InterruptedException | ClassNotFoundException e3) {
//			Can be grouped together	
//		}
//		catch(FileNotFoundException e3) { 
		//Can't be there since it is not being thrown
//			
//		}
		catch(Exception e) {
			//Can be there since the parent of all the Exception and can replace any or all catch block 
			//but any other subclass exception catch clock can't place after this
			
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
