package com.hms.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By userName = By.name("username");
	By password = By.name("password");
	By submit = By.name("submit");

	public LoginPage(WebDriver localdriver) {
		driver = localdriver;
	}

	public void login(String user, String pwd) {
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("submit")).click();
	}
	public void logout(){
		driver.findElement(By.linkText("Logout")).click();
	}
	
	public void fieldsChecking(){
		
	}

}
