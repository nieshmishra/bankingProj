package com.bankingProj.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {

	public String baseURL="http://demo.guru99.com/v4/";
	public String username="mngr376619";
	public String password="ydAzyrE";
	public static WebDriver driver;
	@BeforeClass
	public void Setup() {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		
		driver=new ChromeDriver();
	}
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
	}
	

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest test;
	
	@BeforeTest
	public void SetExtent() {
		
		htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myreport1.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extentReport=new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Hostname", "localHost");
		extentReport.setSystemInfo("BrowserName", "Chrome");
		
	}
	
	@AfterTest
	public void FlushReport() {
		extentReport.flush();
	}
	
	@AfterMethod
	
	public void TearDownResult(ITestResult result) throws IOException {
		
		
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test is Failed"+ result.getName());
			test.log(Status.FAIL, "Test is Failed"+ result.getThrowable());
			
			String Screenshots=BaseClass.GetScreenShot(driver, result.getName());
			test.addScreenCaptureFromPath(Screenshots);
		
		}
		
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, "Test is Skipped"+ result.getName());
			
		}
		
		else if(result.getStatus() == ITestResult.SUCCESS){
			test.log(Status.PASS, "Test is Success"+ result.getName());
			
		}
		
	}
	
	public static String GetScreenShot(WebDriver driver,String Screenshotname) throws IOException{
		
		String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		String Destination=System.getProperty("user.dir")+"/Screenshots/"+ Screenshotname+date+".png";
		
		File finalDestination=new File(Destination);
		FileUtils.copyFile(source, finalDestination);
		
		return Destination;
		
		
	
		
	}
	
}
