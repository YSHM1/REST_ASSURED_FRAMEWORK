package restAssured.utils;

import org.apache.commons.lang3.RandomStringUtils;

import net.datafaker.Faker;

public class DataGenerator {
	
	public static Faker faker = new Faker();
	
	public static String getGeneratedData(DataNames names) {
		switch(names) {
		case FIRSTNAME :
			return faker.name().firstName();
		case LASTNAME :
			return faker.name().lastName();
		case FULLNAME :
			return faker.name().fullName();
		case COUNTRY :
			return faker.address().country();
		case CITYNAME :
			return faker.address().cityName();
		default:
			return "Data Name is not available";
		}	
	}
	
	public  static String getRandomNumber(int count) {
		return faker.number().digits(count);
	}
	
	public static int getNumberBetween(int min, int max) {
		return faker.number().numberBetween(min, max);
	}
	
	public  static String getRandomAlphabets(int size) {
		return RandomStringUtils.randomAlphabetic(size);
	}
	
	public  static String getWebsiteNames(int size) {
		return "https://"+RandomStringUtils.randomAlphabetic(size)+".com";
	}

}
