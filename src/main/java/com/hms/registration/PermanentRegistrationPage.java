package com.hms.registration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.FindActiveElement;
import org.openqa.selenium.support.ui.Select;

import com.hms.util.TempGenericActions;



public class PermanentRegistrationPage {
	
	WebDriver driver;
	By registrationLink=By.linkText("Registration");
	By patientCategory = By.name("PATIENT_CAT");
	By title = By.name("TITLE");
	By firstName = By.name("PNT_NAME");
	By lastName = By.name("LAST_NAME");
	By dob = By.name("DOB");
	By age = By.name("AGE");
	By gender = By.name("SEX");
	By maritalStatus = By.name("MTRL_STATUS");
	By religion = By.name("RELIGION");
	By language = By.name("PLANGUAGE");
	By addrress = By.name("ADDRESS1");
	By mobNo = By.name("MOBILE_NO");
	By countryCode = By.name("COUNTRY_CODE");
	By relation = By.name("RELATION");
	By patientID = By.name("PAT_IDENTITY");
	By pan = By.name("PAT_IDENTITY_PROOF");
	By nationality = By.name("NATIONALITY");
	By vip = By.name("IS_MLC");
	By education = By.name("EDUCATION");
	By ocupation = By.name("OCCUPATION");
	By bloodGroup = By.name("BLOOD_GRP_CODE");
	By citizenship = By.name("CITIZENSHIP");
	By proof = By.name("SC_PROOF");
	By zip = By.name("ZIP");
	By image = By.name("image");
	By save = By.name("submit");
	
	TempGenericActions actions;
	
	public PermanentRegistrationPage(WebDriver localDriver) {
		driver=localDriver;
		actions = new TempGenericActions(driver);
		System.out.println("From Test PAge");
	}
	
	public void goToEmergencyPage(){
		driver.findElement(registrationLink).click();
		driver.findElement(By.linkText("Perminent Registration")).click();
		System.out.println("Registration link clicked");
	}
	
	
	public void permanentRegistration(Map<String,String> sample)throws Exception{
		goToEmergencyPage();
		
		System.out.println("From method");
		
		new Select(driver.findElement(patientCategory)).selectByVisibleText(sample.get("patientcategory"));
		//actions.dropDownUpdate(patientCategory, sample.get("patientCategory"));
		new Select(driver.findElement(title)).selectByVisibleText(sample.get("title"));
		actions.dropDownUpdate(title, sample.get("title"));
		driver.findElement(firstName).sendKeys(sample.get("firstname"));
		actions.updateText(firstName, sample.get("firstName"));
		
		//actions.waitForElementThenClick(firstName, sample.get("firstname"));
		driver.findElement(lastName).sendKeys(sample.get("lastname"));
		driver.findElement(dob).sendKeys(sample.get("dob"));
		driver.findElement(age).sendKeys(sample.get("age"));
		new Select(driver.findElement(gender)).selectByVisibleText(sample.get("gender"));
		new Select(driver.findElement(maritalStatus)).selectByVisibleText(sample.get("maritalstatus"));
		new Select(driver.findElement(religion)).selectByVisibleText(sample.get("religion"));
		new Select(driver.findElement(language)).selectByVisibleText(sample.get("primarylanguage"));
		driver.findElement(addrress).sendKeys(sample.get("address1"));
		//driver.findElement(mobNo).sendKeys(sample.get("phone"));
		actions.fluentUpdateText(mobNo, sample.get("phone"));
		new Select(driver.findElement(countryCode)).selectByVisibleText(sample.get("country"));
		new Select(driver.findElement(relation)).selectByVisibleText(sample.get("relation"));
		new Select(driver.findElement(patientID)).selectByVisibleText(sample.get("patientidentifier"));
		driver.findElement(pan).sendKeys(sample.get("panno"));
		new Select(driver.findElement(nationality)).selectByVisibleText(sample.get("nationality"));
		new Select(driver.findElement(vip)).selectByVisibleText(sample.get("vip"));
		new Select(driver.findElement(education)).selectByVisibleText(sample.get("education"));
		new Select(driver.findElement(ocupation)).selectByVisibleText(sample.get("occupation"));
		new Select(driver.findElement(bloodGroup)).selectByVisibleText(sample.get("bloodgroup"));
		new Select(driver.findElement(citizenship)).selectByVisibleText(sample.get("citizenship"));
		new Select(driver.findElement(proof)).selectByVisibleText(sample.get("seniorcitizen"));
		driver.findElement(zip).sendKeys(sample.get("pinorzip"));
		driver.findElement(image).sendKeys("H:\\Project\\Backup zips\\New Text Document.txt");
		//driver.findElement(save).click();
		actions.clickElement(save);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
			
	}
}
