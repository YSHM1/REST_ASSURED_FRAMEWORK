package reporting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.http.Header;

public class ExtentReportManager {
	
	public static ExtentReports extentReports;
	
	public static ExtentReports createInstance(String filePath, String documentTitle, String reportName) {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filePath);
		extentSparkReporter.config().setDocumentTitle(documentTitle);
		extentSparkReporter.config().setReportName(reportName);
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		extentSparkReporter.config().setEncoding("utf-8");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		
		return extentReports;
	}
	
	public static String getReportNameWithTimeStamp() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH_mm_ss");
		LocalDateTime localDateTime = LocalDateTime.now();
		String formattedTime = dateTimeFormatter.format(localDateTime);
		String reportName = "TestReport"+formattedTime+".html";
		return reportName;
	}
	
	public static void logPassDetails(String log) {
		ExtentReportSetUp.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
	}
	
	public static void logFailureDetails(String log) {
		ExtentReportSetUp.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
	}
	
	public static void logWarningDetails(String log) {
		ExtentReportSetUp.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
	}
	
	public static void logInfoDetails(String log) {
		ExtentReportSetUp.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
	}
	
	public static void logExceptionDetails(String log) {
		ExtentReportSetUp.extentTest.get().fail(log);
	}
	
	
	
	/**
	 * Use to print the JSON Body in proper JSON Format by taking the help of createCodeBlock(jsonBody, CodeLanguage.JSON)
	 * @param json
	 */
	public static void logJSON(String json) {
		ExtentReportSetUp.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
	}
	
	public static void logHeader(List<Header> headerList) {
		String[][] arrayHeader = headerList.stream().map(header -> new String[] {header.getName(), header.getValue()}).toArray(String[][] :: new);
		ExtentReportSetUp.extentTest.get().info(MarkupHelper.createTable(arrayHeader));
	}
	

}
