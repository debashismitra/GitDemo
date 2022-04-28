package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.pageObjectManager;

public class TestContextSetUp {
	public WebDriver driver;
	public String homeProductName;
	public String keyword;
	public String homeWindow;
	public pageObjectManager ObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public String landingItemNumber;
	
	public TestContextSetUp() throws IOException {
		testBase=new TestBase();		
		ObjectManager=new pageObjectManager(testBase.WebDriverManager());
		genericUtils=new GenericUtils(testBase.WebDriverManager());
	}
	
}
