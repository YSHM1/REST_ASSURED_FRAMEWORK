package knowledege;

import java.util.Arrays;
import java.util.stream.Stream;

import restAssured.utils.DataGenerator;

public class POJOExampleForGenderOrFieldWithLimitedValues {
	
	/*
	 * 	 To get value Randomly out of provided Values 
	 *	 Useful when a particular field accepts only specific values / limited values
	 */
	  private String gender_1 = Stream.of("male", "female", "others").findAny().get();
//		         									OR
	  private String gender_2 = Arrays.asList("male", "female", "others").get(DataGenerator.getNumberBetween(0, 3));

	
	/*
	 * Best practice will be to create Gender ENUM and create Constant Value-----> Male, Female 
	 * and Others in ENUM
	 * 
	 * so that even if we are manually  giving value for Gender field it won't be 
	 * out of Scope of the values for Gender field 
	 * (Restricting Gender field values)
	 */ 
	  private Gender gender = Arrays.stream(Gender.values()).findAny().get();
}
