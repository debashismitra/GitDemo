package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetUp;

public class Hooks {
	
	
	
	private TestContextSetUp testContextSetUp;

	public Hooks(TestContextSetUp testContextSetUp) {
		this.testContextSetUp=testContextSetUp;
	}
	
	@After
	public void afterScenario() throws IOException {
		testContextSetUp.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void attachScreenshot(Scenario scenario) throws IOException {
		WebDriver driver=testContextSetUp.testBase.WebDriverManager();
		if(scenario.isFailed()) {
			TakesScreenshot srcreenShot= (TakesScreenshot)driver;
			File srcFIle=srcreenShot.getScreenshotAs(OutputType.FILE);
			byte[] data=FileUtils.readFileToByteArray(srcFIle);
			scenario.attach(data, "image/png", "image");
			
		}
		
	}

}
