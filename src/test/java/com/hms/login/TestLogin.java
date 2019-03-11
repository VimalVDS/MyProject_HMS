package com.hms.login;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.util.DynamicTestDataReading;

public class TestLogin {

	WebDriver driver;
	Map<String, List<Map<String, String>>> testCasesWithSamples;
	Properties prop;
	String projectPath;
	@BeforeSuite
	public void launchBrowser() throws Exception{
		projectPath=System.getProperty("user.dir");
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				projectPath+"\\src\\test\\resources\\properties\\ApplicationUnderTest.properties");
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void beforeClass()throws Exception{
		DynamicTestDataReading dtd=new DynamicTestDataReading();
		testCasesWithSamples=dtd.testDataReading(projectPath+"\\src\\test\\resources\\testdata\\login.xlsx","login","sanity");
	}
	
	@DataProvider(name="testSamples")
	public Object[][] testData(Method method)throws Exception{
		String methodName=method.getName();
		System.out.println(methodName);
		List<Map<String, String>> samples=testCasesWithSamples.get(methodName);
		
		Object[][] obj=null;
		
		if(samples==null){
			obj=new Object[0][0];
		}
		else{
			obj=new Object[samples.size()][2];
			int counter=0;
			for(Map<String,String> sample:samples){
				obj[counter][0]=sample;
				obj[counter][1]=sample.get("Result");
				counter++;
			}
			
		}
		
		return obj;
	}

	@Test(dataProvider="testSamples",priority=1,description="C001:test login checking")
	public void testLogin(Map<String,String> sample,String result) {
		LoginPage page = new LoginPage(driver);
		page.login(sample.get("username"), sample.get("pwd"));
		page.logout();
		
		
	}

	@Test(dataProvider="testSamples",priority=2)
	public void testLoginNegative(Map<String,String> sample,String result)throws Exception {
		LoginPage page = new LoginPage(driver);
		page.login(sample.get("username"),sample.get("pwd"));
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	@Test(dataProvider="testSamples",priority=2)
	public void testLoginFields(Map<String,String> sample,String result) {
		LoginPage page = new LoginPage(driver);
		page.fieldsChecking();
	}
	

}
