package com.hms.registration;

import java.io.File;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.hms.util.TestBaseClass;

public class TestPermanenetRegistration extends TestBaseClass{
	
	public TestPermanenetRegistration() throws Exception{
		excelPath="\\src\\test\\resources\\testdata\\login.xlsx";
		sheetName="registration";
	}
	
	@Test(dataProvider="testSamples")
	public void testPermanentRegistration(Map<String,String> sample,String result)throws Exception{
		PermanentRegistrationPage prs = new PermanentRegistrationPage(driver);
		prs.permanentRegistration(sample);
		System.out.println(sample);
		}
	

	/*@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		
		if (ITestResult.FAILURE == result.getStatus()
				|| ITestResult.SUCCESS == result.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			Integer invocationCount = result.getMethod().getCurrentInvocationCount();
			FileUtils.copyFile(source, new File(projectPath + "/src/test/resources/screenshots/" 
		    + result.getMethod().getMethodName() + invocationCount.toString()+".png"));
	

		}

	}*/

}
