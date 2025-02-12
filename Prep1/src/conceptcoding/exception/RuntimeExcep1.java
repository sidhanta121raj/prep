package conceptcoding.exception;

public class RuntimeExcep1 {

	public static void main(String[] args) {
		RuntimeExcep1 exc = new RuntimeExcep1();
		//exc.method1();
		//exc.method2();
		//exc.method3();
		//exc.method4();
		//exc.method5();
		exc.method6();

	}
	
	private void method1() {
		Object val = 0;
		System.out.println((String)val);
	}
	private void method2() {
		int val = 5/0;
		System.out.println(val);
	}
	private void method3() {
		int[] val = new int[5];
		System.out.println(val[6]);
	}
	private void method4() {
		String val = "Java";
		System.out.println(val.charAt(10));
	}
	private void method5() {
		String val = null;
		System.out.println(val.charAt(10));
	}
	private void method6() {
		Integer i = Integer.parseInt("vhghbn");
	}

}
