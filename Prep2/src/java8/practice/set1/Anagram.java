package java8.practice.set1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {

	public static void main(String[] args) {
		String s1 = "RaceCar";
        String s2 = "CarRace";
        
        s1 = Stream.of(s1.split("")).map(s->s.toUpperCase()).sorted().collect(Collectors.joining());
        s2 = Stream.of(s2.split("")).map(s->s.toUpperCase()).sorted().collect(Collectors.joining());
        
        if(s1.equals(s2)) {
        	System.out.println("Strings are Anagram");
        }else {
        	System.out.println("Given strings are not anangram");
        }

	}

}
