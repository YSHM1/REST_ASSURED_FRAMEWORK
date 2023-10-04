package airline.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import airlinePOJO.Airline;
import io.restassured.response.Response;

public class CreateAirline_3UsingPOJOAndVerifyResponseTest extends AirlineAPI{
	
	@Test
	public void createAirlineAndVerifyResponseTest() throws Exception {
		
		Airline requestPayload = new Airline();
		Response response = createAirline(requestPayload);
		
		ObjectMapper objectMapper = new ObjectMapper();
		Airline actualResponse = objectMapper.readValue(response.getBody().asString(), Airline.class);
		Assert.assertEquals(actualResponse, requestPayload);
	
	}

}
