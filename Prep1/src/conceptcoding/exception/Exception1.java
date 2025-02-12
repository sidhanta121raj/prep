package conceptcoding.exception;

public class Exception1 {

	public static void main(String[] args) {
		Exception1 ex1 = new Exception1();
		ex1.method1();
	}

	private void method1() {
		method2();
	}

	private void method2() {
		method3();
	}

	private void method3() {
		int b = 5/0;
	}

}
