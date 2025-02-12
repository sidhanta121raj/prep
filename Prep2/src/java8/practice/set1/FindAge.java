package java8.practice.set1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//Find the age of a person in years if the birthday has given?
public class FindAge {

	public static void main(String[] args) {
		LocalDate birthDay = LocalDate.of(1985, 01, 23);
        LocalDate today = LocalDate.now();
        
        System.out.println(ChronoUnit.YEARS.between(birthDay, today));

	}

}
