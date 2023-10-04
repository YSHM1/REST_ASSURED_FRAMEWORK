package airline.api.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import airlinePOJO.AirlinePOJO_ForScenarios;
import io.restassured.response.Response;
import restAssured.restUtils.AssertionUtils;
import restAssured.utils.ExcelUtil;

public class CreateAirline_7DataDrivenTestingWithScenariosAndVerifyAirlineUsingAssertionUtilsTest extends AirlineAPI {
	
	@Test(dataProvider = "getAirlineData")
	public void createAirlineDrivenTestingUsingPOIJIAndVerifyAirlineUsingAssertionUtilsTest(AirlinePOJO_ForScenarios airlinePOJO_ForScenarios) {
		
		
		
		if (airlinePOJO_ForScenarios.getExpectedStatusCode() != 200) {
			
			// Create airline with existing airline ID
			if (airlinePOJO_ForScenarios.getScenarioId().equalsIgnoreCase("CreateAirline_DuplicateID")) {
				Response response = createAirline(airlinePOJO_ForScenarios);
				response = createAirline(airlinePOJO_ForScenarios);
				Assert.assertEquals(response.getStatusCode(), airlinePOJO_ForScenarios.getExpectedStatusCode());
				Assert.assertEquals(response.jsonPath().getString("message"), airlinePOJO_ForScenarios.getExpectedErrorMessage());
			}
			
			// Create airline with empty payload
			else if (airlinePOJO_ForScenarios.getScenarioId().equalsIgnoreCase("CreateAirline_EmptyPayload")) {
				Response response = createAirline(airlinePOJO_ForScenarios);
				Assert.assertEquals(response.getStatusCode(), airlinePOJO_ForScenarios.getExpectedStatusCode());
				Assert.assertEquals(response.jsonPath().getString("message"), airlinePOJO_ForScenarios.getExpectedErrorMessage());
			}
			
			// Create airline with just ID
			else if (airlinePOJO_ForScenarios.getScenarioId().equalsIgnoreCase("CreateAirline_OnlyID")) {
				Response response = createAirline(airlinePOJO_ForScenarios);
				Assert.assertEquals(response.getStatusCode(), airlinePOJO_ForScenarios.getExpectedStatusCode());
				Assert.assertEquals(response.jsonPath().getString("message"), airlinePOJO_ForScenarios.getExpectedErrorMessage());
			}
		}
		
		else {
			
			// Create airline with expected request payload/complete request payload
			Map<String, Object> expectedValueMap = new HashMap<String, Object>();
			expectedValueMap.put("id", airlinePOJO_ForScenarios.getId());
			expectedValueMap.put("name", airlinePOJO_ForScenarios.getName());
			expectedValueMap.put("country", airlinePOJO_ForScenarios.getCountry());
			expectedValueMap.put("logo", airlinePOJO_ForScenarios.getLogo());
			expectedValueMap.put("slogan", airlinePOJO_ForScenarios.getSlogan());
			expectedValueMap.put("head_quaters", airlinePOJO_ForScenarios.getHead_quaters());
			expectedValueMap.put("established", airlinePOJO_ForScenarios.getEstablished());
			expectedValueMap.put("website", airlinePOJO_ForScenarios.getWebsite());
			Response response = createAirline(expectedValueMap);
			Assert.assertEquals(response.getStatusCode(), airlinePOJO_ForScenarios.getExpectedStatusCode());
			
			// Create airline without ID 
			if (airlinePOJO_ForScenarios.getScenarioId().equalsIgnoreCase("CreateAirline_WithoutID")) {
				expectedValueMap.remove("id");
				response = createAirline(expectedValueMap);
				Assert.assertEquals(response.getStatusCode(), airlinePOJO_ForScenarios.getExpectedStatusCode());
			}
			
			/*
			else {	
				// Create airline with expected request payload
				Map<String, Object> expectedValueMap = new HashMap<String, Object>();
				expectedValueMap.put("id", airlinePOJO_ForScenarios.getId());
				expectedValueMap.put("name", airlinePOJO_ForScenarios.getName());
				expectedValueMap.put("country", airlinePOJO_ForScenarios.getCountry());
				expectedValueMap.put("logo", airlinePOJO_ForScenarios.getLogo());
				expectedValueMap.put("slogan", airlinePOJO_ForScenarios.getSlogan());
				expectedValueMap.put("head_quaters", airlinePOJO_ForScenarios.getHead_quaters());
				expectedValueMap.put("established", airlinePOJO_ForScenarios.getEstablished());
				expectedValueMap.put("website", airlinePOJO_ForScenarios.getWebsite());
				response = createAirline(expectedValueMap);
				Assert.assertEquals(response.getStatusCode(), airlinePOJO_ForScenarios.getExpectedStatusCode());
			}
			*/
			
		}
	
	}
	
	@DataProvider(name = "getAirlineData")
	public Iterator<AirlinePOJO_ForScenarios> getAirlineDataUsingPoiji() throws EncryptedDocumentException, IOException {
		
		List<LinkedHashMap<String, String>> excelDataAsListOfMap = ExcelUtil.getExcelData("AirlineTestDataWithScenarios", "CreateAirline");
		List<AirlinePOJO_ForScenarios> airlineData = new ArrayList<>();
				
		for (LinkedHashMap<String, String> data : excelDataAsListOfMap) {
			AirlinePOJO_ForScenarios airlinePOJO_ForScenarios = getCustomizeAirlineData(data);
			 airlineData.add(airlinePOJO_ForScenarios);
		}
		return airlineData.iterator();
	}
	
	private AirlinePOJO_ForScenarios getCustomizeAirlineData(LinkedHashMap<String, String> data) {
		
		AirlinePOJO_ForScenarios airlinePOJO_ForScenarios = new AirlinePOJO_ForScenarios();
		airlinePOJO_ForScenarios.setScenarioId(data.get("ScenarioID"));
		airlinePOJO_ForScenarios.setScenarioDesc(data.get("ScenarioDesc"));
		airlinePOJO_ForScenarios.setExpectedStatusCode(Integer.parseInt(data.get("ExpectedStatusCode")));
		
		if (!data.get("ExpectedErrorMessage").equals("NO_DATA")) {
			airlinePOJO_ForScenarios.setExpectedErrorMessage(data.get("ExpectedErrorMessage"));
		}
		
		if (!data.get("id").equalsIgnoreCase("NO_DATA")) {
			airlinePOJO_ForScenarios.setId(Integer.parseInt(data.get("id")));
		}
		
		if (!data.get("name").equalsIgnoreCase("NO_DATA")) {
			airlinePOJO_ForScenarios.setName(data.get("name"));
		}
		
		if (!data.get("country").equalsIgnoreCase("NO_DATA")) {
			airlinePOJO_ForScenarios.setCountry(data.get("country"));
		}
		
		if (!data.get("logo").equalsIgnoreCase("NO_DATA")) {
			airlinePOJO_ForScenarios.setLogo(data.get("logo"));
		}
		
		if (!data.get("slogan").equalsIgnoreCase("NO_DATA")) {
			airlinePOJO_ForScenarios.setSlogan(data.get("slogan"));;
		}
		
		if (!data.get("head_quaters").equalsIgnoreCase("NO_DATA")) {
			airlinePOJO_ForScenarios.setHead_quaters("head_quaters");;
		}
		
		if (!data.get("website").equalsIgnoreCase("NO_DATA")) {
			airlinePOJO_ForScenarios.setWebsite(data.get("website"));
		}
		
		if (!data.get("established").equalsIgnoreCase("NO_DATA")) {
			airlinePOJO_ForScenarios.setEstablished(data.get("established"));
		}
		return airlinePOJO_ForScenarios;
	}

}
