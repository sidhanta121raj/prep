package java8.practice.set1;

import java.util.stream.IntStream;

//Pallindrome program using Java 8 streams
public class Pallindrome {

	public static void main(String[] args) {
		String str = "ROTATORS";
		
		boolean isPallindrome = IntStream.range(1, str.length()/2).noneMatch(i-> str.charAt(i) != str.charAt(str.length()-i-1));
		

		if(isPallindrome) {
			System.out.println(str+" is Pallindrome.");
		}else {
			System.out.println(str+" is not a Pallindrome.");
		}
	}

}
