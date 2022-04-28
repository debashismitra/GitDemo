package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By search=By.xpath("//input[@type='search']");
	By productName=By.xpath("//h4[@class='product-name']");
	By linkText=By.linkText("Top Deals");
	By increment=By.xpath("//a[@class='increment']");
	By decrement=By.xpath("//a[@class='decrement']");
	By addtocart=By.xpath("//button[text()='ADD TO CART']");
	
	public void clickTopDeal(){
		driver.findElement(linkText).click();
	}
	public void landingSearch(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public String getHomeWindow() {
		return driver.getWindowHandle();
	}
	
	public void incrementProduct(String itemno) {
		int itemnumber=Integer.parseInt(itemno);
		for (int i=1;i<itemnumber;i++) {
			new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(increment)).click();
		}
		
	}
	
	public void decrementProduct(String itemno) {
		int itemnumber=Integer.valueOf(itemno);
		for (int i=1;i<=itemnumber;i++) {
			driver.findElement(decrement).click();
		}
		
	}
	
	public void addToCart() {
		driver.findElement(addtocart).click();
	}
	
	public String getLandingPageTitle() {
		return driver.getTitle();
	}
	
}
