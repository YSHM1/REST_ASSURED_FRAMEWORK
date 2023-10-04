package restAssured.utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static Map<String, Object> getJsonDataAsMap(String jsonFilePath)  {
		String completeJsonFilePath = System.getProperty("user.dir")+"/src/test/resources"+jsonFilePath;
		
		Map<String, Object> data = null;
		try {
			data = objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<>() {});

			/*
			 * for Java version 1.8
			 * data = objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<Map<String, Object>>() {});
			 * 											OR
			 * data = objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<HashMap<String, Object>>() {});
			 * 											OR
			 * data = objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<List<HashMap<String, Object>>>() {});
			 * 											OR
			 * ---------------------------------------------
			 * Depends on Requirement
			 */
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
