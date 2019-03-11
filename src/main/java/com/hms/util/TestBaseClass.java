package com.hms.util;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.hms.login.LoginPage;

public abstract class TestBaseClass {
	
	Logger log = Logger.getLogger(TestBaseClass.class.getName());
	
	protected WebDriver driver;
	
	
	
	protected Map<String, List<Map<String, String>>> testCasesWithSamples;
	protected Properties prop;
	protected String projectPath;
	protected String excelPath;
	protected String sheetName;
	


	public TestBaseClass() throws Exception{
		
		try {
			log.info("Project path reading");
			
			
			//driver.manage().timeouts().implicitlyWait(time, unit)
			
			projectPath = System.getProperty("user.dir");
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
			projectPath + "\\src\\test\\resources\\properties\\ApplicationUnderTest.properties");
			prop.load(fis);
			
			
			log.info("Reading properties file is done");
			
			} catch (Exception e) {
			log.error("Properties file reading failed"); 
		}
		
	}

	@BeforeSuite
	public void launchBrowser() throws Exception {
		
			
			try {
				
				
				if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver",
							projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
					driver = new ChromeDriver();
				} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver",
							projectPath + "\\src\\test\\resources\\drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
				} else if (prop.getProperty("browser").equalsIgnoreCase("ie")) {
					System.setProperty("webdriver.ie.driver",
							projectPath + "\\src\\test\\resources\\drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
				driver.get(prop.getProperty("url"));
				driver.manage().window().maximize();
			} catch (Exception e) {
				log.error("Browser launching is failed");
			}

	}

	@BeforeTest
	public void login() throws Exception {
		try {
			LoginPage page = new LoginPage(driver);
			page.login(prop.getProperty("userName"), prop.getProperty("password"));
			log.info("Login is done");
		} catch (Exception e) {
			log.error("Login is failed");
		}
		
		//Thread.sleep(5000);
	}

	@BeforeClass
	public void beforeClass() throws Exception {
		DynamicTestDataReading dtd = new DynamicTestDataReading();
		testCasesWithSamples = dtd.testDataReading(projectPath + excelPath,
				sheetName,prop.getProperty("testDataType"));
		
	}

	@DataProvider(name = "testSamples")
	public Object[][] testData(Method method) throws Exception {
		String methodName = method.getName();
		System.out.println(methodName);
		List<Map<String, String>> samples = testCasesWithSamples.get(methodName);

		Object[][] obj = null;
		System.out.println("from dataprovider");

		if (samples == null) {
			obj = new Object[0][0];
		} else {
			obj = new Object[samples.size()][2];
			int counter = 0;
			for (Map<String, String> sample : samples) {
				obj[counter][0] = sample;
				obj[counter][1] = sample.get("Result");
				counter++;
			}

		}
		
		return obj;
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		log.info("screenshot capturing is started");
		if (ITestResult.FAILURE == result.getStatus()
				|| ITestResult.SUCCESS == result.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			Integer invocationCount = result.getMethod().getCurrentInvocationCount();
			FileUtils.copyFile(source, new File(projectPath + "/src/test/resources/screenshots/" 
		    + result.getMethod().getMethodName() + invocationCount.toString()+".png"));
	
			log.info("screenshot capturing is done..");
		}

	}
	
	

}
