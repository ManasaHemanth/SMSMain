package com.SMS.genericutils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplClass implements ITestListener {
ExtentReports reports;
ExtentTest test;
	@Override
	public void onTestStart(ITestResult result)
	{
//actual testscript execution start from here
		
		String MethodName = result.getMethod().getMethodName();
		test=reports.createTest(MethodName);
		Reporter.log(MethodName+" Execution start");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"    passed" );
		Reporter.log(MethodName+"--- Testscript executed");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		try {
		String failedscript=WebdriverUtilities.screenshotDemo(BaseClass.sdriver, MethodName) ;
		test.addScreenCaptureFromPath(failedscript);
		}catch(Throwable e) 
		{
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL,MethodName+"failed");
		Reporter.log(MethodName+" failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, MethodName+"skipped");
		Reporter.log(MethodName+"skipped");
	}

	@Override
	public void onStart(ITestContext context) 
	{

		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./Extentreport/report.html");
		htmlreport.config().setDocumentTitle("SDET-51");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("SMS");
		
		reports =new ExtentReports();
		reports.attachReporter(htmlreport);
		reports.setSystemInfo("os", "window-11");
		reports.setSystemInfo("Base Browser", "chrome");
		reports.setSystemInfo("Base-url", "http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		reports.setSystemInfo("ReporterName", "Sameer");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		reports.flush();
	}
	
	

}
