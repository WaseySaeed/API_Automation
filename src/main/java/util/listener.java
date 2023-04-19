package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

import static util.extentReport.logFailureDetails;

public class listener implements ITestListener {

    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public void onStart(ITestContext context) {
        extentReports =  extentReport.createInstance("API Automation Report");
    }

    public void onFinish(ITestContext context) {
        if(extentReports != null) {extentReports.flush();}
    }

    public void onTestStart(ITestResult result)
    {
        ExtentTest testName = extentReports.createTest(result.getTestClass().getName() +" - " + result.getMethod().getMethodName());
        extentTest.set(testName);
    }

    public void onTestFailure(ITestResult result)
    {
        logFailureDetails(result.getThrowable().getMessage());
        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replaceAll(",","<br>");
        logFailureDetails(stackTrace);
    }
}
