package com.corejava;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReadingDemo {

	public static void main(String[] args)throws Exception {
	
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream
("G:\\SELENIUM KOSMIK 8 AM JAN 4\\taf-20\\src\\test\\resources\\properties\\ApplicationUnderTest.properties");
		prop.load(fis);
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.get("userName"));
		System.out.println(prop.get("password"));
		System.out.println(prop.get("browser"));
		
		System.out.println(System.getProperty("user.dir"));
		

	}

}
