package airline.api.test;

import java.util.HashMap;
import java.util.Map;

import airlinePOJO.Airline;
import restAssured.utils.DataGenerator;
import restAssured.utils.DataNames;
import restAssured.utils.DateUtil;

public class RequestPayload {
	
	public static String createRequestPayloadUsingString(String id, String name, String country,
			String logo, String slogan, String head_quaters, String website, String established) {
		String payload = "{\r\n"
				+ "				\"id\" : "+id+",\n"
				+ "				\"name\" : "+name+",\n"
				+ "				\"country\" : "+country+",\n"
				+ "				\"logo\" : "+logo+",\n"
				+ "				\"slogan\" : "+slogan+",\n"
				+ "				\"head_quaters\" : "+head_quaters+",\n"
				+ "				\"website\" : "+website+",\n"
				+ "				\"established\" : "+established+"\n"
				+ "				}";
		
		return payload;
	}
	
	public static Map<String, Object> createRequestPayloadUsingMap(String id, String name, 
			String country, String logo, String slogan, String head_quaters, String website,
																			String established) {
		
		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put("id",id);
		payload.put("name", name);
		payload.put("country", country);
		payload.put("logo", logo);
		payload.put("slogan", slogan);
		payload.put("head_quaters", head_quaters);
		payload.put("website", website);
		payload.put("established", established);
		
		return payload;
	}
	
//	public static Airline createRequestPayloadUsingPOJO() {
//		return Airline
//				.builder()
//				.id(Integer.parseInt(DataGenerator.getRandomNumber(6)))
//				.name(DataGenerator.getGeneratedData(DataNames.FULLNAME))
//				.country(DataGenerator.getGeneratedData(DataNames.COUNTRY))
//				.logo(DataGenerator.getRandomAlphabets(8))
//				.slogan(DataGenerator.getRandomAlphabets(15))
//				.head_quaters(DataGenerator.getGeneratedData(DataNames.CITYNAME))
//				.website(DataGenerator.getWebsiteNames(15))
//				.established(DataGenerator.getNumberBetween(1980, DateUtil.getCurrentYear()))
//				.build();
//	}

}
