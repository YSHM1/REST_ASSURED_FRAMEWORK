package airline.api.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import airlinePOJO.Airline;
import io.restassured.response.Response;
import restAssured.restUtils.AssertionUtils;

public class createAirline_4UsingHashMap_POJOAndVerifyAirlineUsingAssertionUtilsTest extends AirlineAPI{
	
	@Test
	public void createAirlineAndVerifyAirlineUsingAssertionUtilsTest() throws Exception {
		
		Airline requestPayload = new Airline();
		Response response = createAirline(requestPayload);
		
		Map<String, Object> expectedValueMap = new HashMap<String, Object>();
		expectedValueMap.put("id", requestPayload.getId());
		expectedValueMap.put("name", requestPayload.getName());
		expectedValueMap.put("country", requestPayload.getCountry());
		expectedValueMap.put("logo", requestPayload.getLogo());
		expectedValueMap.put("slogan", requestPayload.getSlogan());
		expectedValueMap.put("head_quaters", requestPayload.getHead_quaters());
		expectedValueMap.put("established", requestPayload.getEstablished());
		expectedValueMap.put("website", requestPayload.getWebsite());
		
		AssertionUtils.assertExpectedValueWithJSON_Path(response, expectedValueMap);
		
	}

}
