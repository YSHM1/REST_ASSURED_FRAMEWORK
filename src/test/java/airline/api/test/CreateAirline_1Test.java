package airline.api.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import airlinePOJO.Airline;
import io.restassured.response.Response;
import restAssured.restUtils.AssertionUtils;

public class CreateAirline_1Test extends AirlineAPI{
	
	@Test
	public void createAirlineTest() throws Exception {
		
		
		Map<String, Object> requestPayload = RequestPayload.createRequestPayloadUsingMap("12346", "Qatar Airlines", "Qatar", "logoUrl", "abcd", "Qatar", "www.qatarairlines.com", "1999");
		Response response = createAirline(requestPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
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
