package airline.api.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.poiji.bind.Poiji;

import airlinePOJO.Airline;
import io.restassured.response.Response;
import restAssured.restUtils.AssertionUtils;
import restAssured.utils.JavaUtil;

public class CreateAirline_6DataDrivenTestingUsingPOIJIAndVerifyAirlineUsingAssertionUtilsTest extends AirlineAPI {
	
	@Test(dataProvider = "getPoijiAirlineData")
	public void createAirlineDrivenTestingUsingPOIJIAndVerifyAirlineUsingAssertionUtilsTest(Airline airline) {
	
		String cellValue = airline.getIdValue();
		int id = Integer.parseInt(JavaUtil.getRandomDataUsing_ExcelCellValue(cellValue));
		airline.setId(id);
		
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
	
	@DataProvider(name = "getPoijiAirlineData")
	public Iterator<Airline> getAirlineDataUsingPoiji() throws EncryptedDocumentException, IOException {
		List<Airline> airlineData = Poiji.fromExcel(new File(".\\src\\test\\resources\\testdata\\AirlineTestData.xlsx"), Airline.class);
		return airlineData.iterator();
	}

}
