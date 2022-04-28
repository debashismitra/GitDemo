package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	WebDriver driver;
	public WebDriver WebDriverManager() throws IOException {
		if(driver==null) {
			FileInputStream stream=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\global.properties");
			Properties prop=new Properties();
			prop.load(stream);
			
			String url=prop.getProperty("url");
			String browser_property=prop.getProperty("browser");
			String browser_system=System.getProperty("browser");
			
			String browser=(browser_system!=null)?browser_system:browser_property;
			
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
//				String homePage="https://rahulshettyacademy.com/seleniumPractise/#/";
				driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\geckodriver-v0.31.0-win64.zip");
//				String homePage="https://rahulshettyacademy.com/seleniumPractise/#/";
				driver=new FirefoxDriver();
			}

			driver.manage().window().maximize();
			driver.get(url);
		}

		
		return driver;
		
	}
}

