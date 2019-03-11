package com.hms.registration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EmergencyRegistration {
	
	WebDriver driver;
	
	By registrationLink=By.linkText("Registration");
	By emergencyRegistrationLink=By.linkText("Emergency Registration");
	By patCategory=By.name("PATIENT_CAT");
	By title=By.name("TITLE");
	By firstName=By.name("PNT_NAME");
	By latName=By.name("LAST_NAME");
	By dob=By.name("DOB");
	By age=By.name("AGE");
	By gender=By.name("SEX");
	By addree=By.name("ADDRESS1");
	By mobileNO=By.name("MOBILE_NO");
	By patIdentifier=By.name("PAT_IDENTITY");
	By pan=By.name("PAT_IDENTITY_PROOF");
	By bloodGroup=By.name("BLOOD_GRP_CODE");
	By pinOrZip=By.name("ZIP");
	By image=By.name("image");
	By save=By.name("submit");
	
	public EmergencyRegistration(WebDriver localDriver) {
		driver = localDriver;
	}
	
	public void goToEmergencyPage(){
		driver.findElement(registrationLink).click();
		driver.findElement(emergencyRegistrationLink).click();
	}
	
	public void emergencyRegistrationSave(Map<String,String> sample)throws Exception {
		goToEmergencyPage();
new Select(driver.findElement(patCategory)).selectByVisibleText(sample.get("patCat"));
new Select(driver.findElement(title)).selectByVisibleText(sample.get("title"));
driver.findElement(firstName).sendKeys(sample.get("firstname"));
driver.findElement(latName).sendKeys(sample.get("lastname"));
driver.findElement(dob).sendKeys(sample.get("dob"));
driver.findElement(age).sendKeys(sample.get("age"));
new Select(driver.findElement(gender)).selectByVisibleText(sample.get("gender"));
driver.findElement(addree).sendKeys(sample.get("address1"));
driver.findElement(mobileNO).sendKeys(sample.get("phone"));
new Select(driver.findElement(patIdentifier)).selectByVisibleText(sample.get("patIdentifier"));
driver.findElement(pan).sendKeys(sample.get("pan"));
new Select(driver.findElement(bloodGroup)).selectByVisibleText(sample.get("blood group"));
driver.findElement(pinOrZip).sendKeys(sample.get("pin or zip"));
driver.findElement(image).sendKeys("H:\\Project\\Backup zips\\New Text Document.txt");
driver.findElement(save).click();

Thread.sleep(3000);
driver.switchTo().alert().accept();


	}
	
	
	
	
	
	
}
