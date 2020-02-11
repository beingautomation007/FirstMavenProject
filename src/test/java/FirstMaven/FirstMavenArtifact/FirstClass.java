package FirstMaven.FirstMavenArtifact;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FirstClass {
	
	ExtentReports reports;
	ExtentTest eTest;
	
	@BeforeTest
	public void beforeTest(){
		reports = new ExtentReports(".//Resources//FirstExtentReport1.html");
		eTest = new ExtentTest("First Test", "My new Test");
		eTest = reports.startTest("New Test");
		reports.addSystemInfo("User Name", "Vijay Test");
		reports.addSystemInfo("Browser", "Chrome");
	}
	
	@Test
	public void testMethod1(){
		System.out.println("First Method");
		eTest.addScreenCapture("C:\\Users\\admin\\Desktop\\screenshot.PNG");
		
	//	eTest.log(LogStatus.INFO, "First Test got passed");
	//	eTest.log(LogStatus.PASS, "First Test got passed");
	}
	
	@Test
	public void testMethod2(){
		Assert.assertEquals(false, true);
		System.out.println("Second Method");
	//	eTest.log(LogStatus.SKIP, "First Test got passed");
	//	eTest.log(LogStatus.FAIL, "Second Test got passed");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result){
		
		if(result.getStatus() == result.FAILURE){
			eTest.log(LogStatus.FAIL, "Test Got Failed");
		}else{
			eTest.log(LogStatus.PASS, "Test Got Passed");
			eTest.addScreenCapture("C:\\Users\\admin\\Desktop\\screenshot.PNG");
		}
		
	}
	
	
	@AfterTest
	public void afterTest(){
		
		reports.endTest(eTest);
		reports.flush();
	}

}
