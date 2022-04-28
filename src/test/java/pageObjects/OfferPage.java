package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	WebDriver driver;
	
	public OfferPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By offerProduct=By.xpath("//tr/td[1]");
	By offerPageSearch=By.id("search-field");
	

	
	public void offerPageSearch(String name) {
		 driver.findElement(offerPageSearch).sendKeys(name);
	}
	
	public String getOfferPageProductName() {
		return driver.findElement(offerProduct).getText();
	}
}
