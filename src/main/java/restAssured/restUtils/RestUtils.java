package restAssured.restUtils;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

public class RestUtils {
	
	/**
	 * 
	 * @param endpoint
	 * @param requestPayload RequestPayload is of Object type so it can accept any type of request like String, Map, Json, File, POJO etc.
	 * @param headers
	 * @return 
	 */
	private static RequestSpecification getRequestSpecification(String endpoint, Object requestPayload, Map<String, String> headers) {
		return RestAssured.given()
				.baseUri(endpoint)
				.headers(headers)
				.contentType(ContentType.JSON)
				.body(requestPayload);
	}
	
	public static void printRequestLogInReport(RequestSpecification requestSpecification) {
		QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
		ExtentReportManager.logInfoDetails("Method is "+queryableRequestSpecification.getMethod());
		ExtentReportManager.logInfoDetails("Endpoint is "+queryableRequestSpecification.getBaseUri());
		ExtentReportManager.logInfoDetails("Header are ");
		ExtentReportManager.logHeader(queryableRequestSpecification.getHeaders().asList());
		ExtentReportManager.logInfoDetails("Request Body is ");
		ExtentReportManager.logJSON(queryableRequestSpecification.getBody());
		
	}
	
	public static void printResponseLogInReport(Response response) {
		ExtentReportManager.logInfoDetails("Response Status is "+response.getStatusCode());
		ExtentReportManager.logInfoDetails("Response Header are ");
		ExtentReportManager.logHeader(response.getHeaders().asList());
		ExtentReportManager.logInfoDetails("Response Body is ");
		ExtentReportManager.logJSON(response.getBody().asPrettyString());
	}
	
	public static Response performPost(String endpoint, String requestPayload, Map<String, String> headers) {
		RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayload, headers);
		Response response = requestSpecification.post();
		printRequestLogInReport(requestSpecification);
		printResponseLogInReport(response);
		return response;
	}
	
	public static Response performPost(String endpoint, Map<String, Object> requestPayload, Map<String, String> headers) {
		RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayload, headers);
		Response response = requestSpecification.post();
		printRequestLogInReport(requestSpecification);
		printResponseLogInReport(response);
		return response;
	}
	
	/**
	 * Performs post request using POJO type requestPayload
	 * @param endpoint
	 * @param requestPayload
	 * @param headers
	 * @return
	 */
	public static Response performPost(String endpoint, Object requestPayload, Map<String, String> headers) {
		RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayload, headers);
		Response response = requestSpecification.post();
		printRequestLogInReport(requestSpecification);
		printResponseLogInReport(response);
		return response;
	}

}
