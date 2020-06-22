package com.crb.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crb.base.BasePage;

public class ExtentReport extends TestListenerAdapter {

	public ExtentReports report;
	public ExtentTest test;
	public ExtentHtmlReporter htmlReport; 
	
	
	
	public void onStart(ITestContext testContext) {
  
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp

		String repName = "Test-Report-" + timeStamp + ".html";
		// location of the report
		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);
		
		htmlReport.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		report = new ExtentReports();

		report.attachReporter(htmlReport);
		report.setSystemInfo("Host name", "localhost");
		report.setSystemInfo("Environemnt", "QA");
		report.setSystemInfo("user", "Nimisha");

		htmlReport.config().setDocumentTitle("Carbonite Web Project"); // Title of report
		htmlReport.config().setReportName("Carbonite Automation Report"); // Name of the report
		htmlReport.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		htmlReport.config().setTheme(Theme.STANDARD);
	}

	public void onTestSuccess(ITestResult tr) {
		test = report.createTest(tr.getName()); // create new entry in the report
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed information
																							// to the report with GREEN
																							// color highlighted
	}

	public void onTestFailure(ITestResult tr) {
		test = report.createTest(tr.getName()); // create new entry in the report
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed information
																						// to the report with GREEN																		// color highlighted
        //adding screenshots
		BasePage.captureScreen(tr.getMethod().getMethodName());
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f = new File(screenshotPath); 
		if(f.exists()) {
			try {
				test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void onTestSkipped(ITestResult tr) {
		test = report.createTest(tr.getName()); // create new entry in th report
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext) {
		report.flush();
	}

}
