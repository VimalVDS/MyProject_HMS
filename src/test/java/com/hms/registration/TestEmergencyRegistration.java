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

public class TestEmergencyRegistration extends TestBaseClass {

	public TestEmergencyRegistration() throws Exception {
		excelPath = "\\src\\test\\resources\\testdata\\login.xlsx";
		System.out.println("from reg");
		sheetName = "registration";
	}

	@Test(dataProvider ="testSamples")
	public void testEmergencyRegistration(Map<String, String> sample, String result) throws Exception {
		EmergencyRegistration em = new EmergencyRegistration(driver);
		em.emergencyRegistrationSave(sample);
		
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
