package com.hms.util;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TempGenericActions {
	WebDriver driver;
	
	public TempGenericActions(WebDriver localDriver){
		driver = localDriver;
	}
	
	public void clickElement(By by){
		WebElement element = driver.findElement(by);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	public void updateText(By by, String text){
		WebElement element = driver.findElement(by);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
	}
	
	public void dropDownUpdate(By by, String text){
		WebElement element = driver.findElement(by);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.visibilityOf(element));
		new Select(element).selectByVisibleText(text);
	}
	
	/***********************FluentWait************************/
	
	public void fluentUpdateText(By by, String text){
		WebElement element = driver.findElement(by);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(FileNotFoundException.class);
		
		element = wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
		
	}

}
