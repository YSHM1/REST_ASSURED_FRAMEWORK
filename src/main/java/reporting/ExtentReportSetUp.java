package reporting;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportSetUp implements ITestListener{
	
	private static ExtentReports extentReports;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>(); 
	
	@Override
	public void onStart(ITestContext context) {
		
		String fileName = ExtentReportManager.getReportNameWithTimeStamp();
		String reportFullPath = System.getProperty("user.dir")+"\\reports\\"+fileName;
		extentReports = ExtentReportManager.createInstance(reportFullPath, "Test ExecutionReport", "Test API Autoation Report");
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extentReports != null) {
			extentReports.flush();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("getTestClass() Name - "+result.getTestClass().getName());
		System.out.println("getMethod() Name - "+result.getMethod().getMethodName());
		System.out.println("getTestMethod().getClass Simple Name - "+result.getMethod().getClass().getSimpleName());
		
		ExtentTest test = extentReports.createTest("Test Name "+ result.getTestClass().getName()+" - "+ result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReportManager.logFailureDetails(result.getThrowable().getMessage()); //print only failure reason without stackTrace
		
//		ExtentReportManager.logFailureDetails(result.getThrowable());
		
		String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
		stackTrace = stackTrace.replaceAll(",", "<br>");
		
		//<details> html tag used to make exception log interactive by showing log only when clicked
		String formattedStackTrace = "<details>\n"
				+ "    <summary>Click here to Exception Logs</summary>\n "
				+ ""+stackTrace+""
				+ "</details>";
		ExtentReportManager.logExceptionDetails(formattedStackTrace);
//		extentTest.get().fail(result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
