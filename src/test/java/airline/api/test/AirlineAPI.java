package airline.api.test;

import java.util.HashMap;
import java.util.Map;

import airlinePOJO.Airline;
import airlinePOJO.AirlinePOJO_ForScenarios;
import io.restassured.response.Response;
import restAssured.restUtils.RestUtils;

public class AirlineAPI{
	
	public Response createAirline(Map<String, Object> createAirlinePayload) {
		String endpoint = (String) Base.jsonFileData.get("createAirlineEndpoint");
		return RestUtils.performPost(endpoint, createAirlinePayload, new HashMap<>());
	}
	
	public Response createAirline(Airline createAirlinePayload) {
		String endpoint = (String) Base.jsonFileData.get("createAirlineEndpoint");
		return RestUtils.performPost(endpoint, createAirlinePayload, new HashMap<>());
	}
	
	public Response createAirline(AirlinePOJO_ForScenarios createAirlinePayload) {
		String endpoint = (String) Base.jsonFileData.get("createAirlineEndpoint");
		return RestUtils.performPost(endpoint, createAirlinePayload, new HashMap<>());
	}

}
