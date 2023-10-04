package airline.api.test;

import java.util.Map;

import restAssured.utils.JsonUtils;

public class Base {
	
	public static Map<String, Object> jsonFileData;
	
	static {
		String env = System.getProperty("env")==null ? "qa" : System.getProperty("env");
		jsonFileData = JsonUtils.getJsonDataAsMap("\\airline\\"+env+"\\AirlineApiData.json");
	}

}
