package UtilityLayer;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseLayer.BaseClass;

public class ExtentReportSetup extends BaseClass {

	public static ExtentReports setup(String reportname) {
		ExtentReports extentreports = new ExtentReports();
		String destinationPath = System.getProperty("user..dir") + "//ExtentReports//"
				+ DateAndTime.captureCurrentYear() + "//" + DateAndTime.captureCurrentMonthAndYear() + "//" + reportname
				+ DateAndTime.captureDateAndTime() + ".html";
		extentreports.attachReporter(new ExtentSparkReporter(destinationPath));

		return extentreports;
	}
}
