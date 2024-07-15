package UtilityLayer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListernerSetup extends AnnotationSetup implements ITestListener {

	private static ExtentReports extentreports;
	private static ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		extentreports = ExtentReportSetup.setup(context.getSuite().getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentreports.createTest("testCase Started Name" + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String passTestCase = result.getMethod().getMethodName();
		extentTest.log(Status.PASS, passTestCase);
		String destinationPath = null;
		try {
			destinationPath = Screenshot.takeScreenshot("PassScreenshot", passTestCase);
		} catch (Exception e) {
			e.printStackTrace();
		}
		extentTest.addScreenCaptureFromPath(destinationPath);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String failtestcase = result.getMethod().getMethodName();
		extentTest.log(Status.FAIL, failtestcase);
		String destinationPath = null;
		try {
			destinationPath = Screenshot.takeScreenshot("FailScreenshot", failtestcase);
		} catch (Exception e) {
			e.printStackTrace();
		}
		extentTest.addScreenCaptureFromPath(destinationPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreports.flush();
	}

}
