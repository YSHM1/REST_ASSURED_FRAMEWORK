package airline.api.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import airlinePOJO.Airline;
import io.restassured.response.Response;
import restAssured.restUtils.AssertionUtils;
import restAssured.utils.ExcelUtil;

public class createAirline_5DataDrivenTestingUsingExcelUtil_POJOAndVerifyAirlineUsingAssertionUtilsTest extends AirlineAPI {
	
	@Test(dataProvider = "airlineData")
	public void createAirlineDataDrivenTestingUsingExcelUtil_POJOAndVerifyAirlineUsingAssertionUtilsTest(Airline airline) throws Exception {
		
		System.out.println(airline);
		Response response = createAirline(airline);

		Map<String, Object> expectedValueMap = new HashMap<String, Object>();
		expectedValueMap.put("id", airline.getId());
		expectedValueMap.put("name", airline.getName());
		expectedValueMap.put("country", airline.getCountry());
		expectedValueMap.put("logo", airline.getLogo());
		expectedValueMap.put("slogan", airline.getSlogan());
		expectedValueMap.put("head_quaters", airline.getHead_quaters());
		expectedValueMap.put("established", airline.getEstablished());
		expectedValueMap.put("website", airline.getWebsite());

		AssertionUtils.assertExpectedValueWithJSON_Path(response, expectedValueMap);

	}
	
	@DataProvider(name = "airlineData")
	public Iterator<Airline> getAirlineData() throws EncryptedDocumentException, IOException {
		List<LinkedHashMap<String, String>> excelDataAsListOfMap = ExcelUtil.getExcelData("AirlineTestData", "CreateAirline");
		Airline airline = new Airline();
		List<Airline> airlineData = new ArrayList<>();
		for (LinkedHashMap<String, String> data : excelDataAsListOfMap) {
			airline.setId(Integer.parseInt(data.get("id")));
			airline.setName(data.get("name"));
			airline.setCountry(data.get("country"));
			airline.setLogo(data.get("logo"));
			airline.setSlogan(data.get("slogan"));
			airline.setHead_quaters(data.get("head_quaters"));
			airline.setEstablished(data.get("established"));
			airline.setWebsite(data.get("website"));
		}
		airlineData.add(airline);
		return airlineData.iterator();
	}

}
