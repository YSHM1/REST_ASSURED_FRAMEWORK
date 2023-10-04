package restAssured.restUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.response.Response;
import reporting.ExtentReportManager;
import reporting.ExtentReportSetUp;

public class AssertionUtils {
	
	public static void assertExpectedValueWithJSON_Path(Response response, Map<String, Object> expectedValueMap) {
		List<AssertionKeys> actualValuesMap = new ArrayList<>();
		
		//Table Header in Extent Report
		actualValuesMap.add(new AssertionKeys("JSON_PATH", "EXPECTED_VALUE", "ACTUAL_VALUE", "RESULT"));
		
		boolean allMatched = true;
		
		//Fetching Keys of expected_Response to use as a jsonPath
		Set<String> jsonPaths = expectedValueMap.keySet();
		
		//iterating through response to extract actualValue of response
		for (String jsonPath : jsonPaths) {
			
			/*
			 * Using Optional.ofNullable(response.jsonPath().get(jsonPath)) to avoid 
			 * NullPointerException incase wrong jsonPath is provided in 
			 * response.jsonPath().get(jsonPath) 
			 */
			Optional<Object> actualValue = Optional.ofNullable(response.jsonPath().get(jsonPath));
			if (actualValue.isPresent()) {
				Object value = actualValue.get();
				
				// Assert actual and expected values
				if (value.equals(expectedValueMap.get(jsonPath))) {
					// if value is matched then add details
					actualValuesMap.add(new AssertionKeys(jsonPath, expectedValueMap.get(jsonPath),
																			value, "Matched ✔"));
				}
				
				else {
					// if assertion is failed then to update final result as failure
					allMatched = false;
					actualValuesMap.add(new AssertionKeys(jsonPath, expectedValueMap.get(jsonPath),
																		value, "Not Matched ❌"));
				}
			}
			
			//if jsonPath does not exit in Response
			else {
				allMatched = false;
				actualValuesMap.add(new AssertionKeys(jsonPath, expectedValueMap.get(jsonPath),
														"Value Not Found", "Not Matched ❌"));
			}
		}
		
		if (allMatched) {
			ExtentReportManager.logPassDetails("All Assertions are passed");
		}
		else
			ExtentReportManager.logFailureDetails("All Assertions are not passed");
		
		 // To log the details in a tabular format in extent report
        String[][] finalAssertionsMap = actualValuesMap.stream().map(assertions -> new String[] {assertions.getJsonPath(),
                String.valueOf(assertions.getExpectedValues()), String.valueOf(assertions.getActualValues()), assertions.getResult()})
                .toArray(String[][] :: new);
        ExtentReportSetUp.extentTest.get().info(MarkupHelper.createTable(finalAssertionsMap));
		
	}

}
