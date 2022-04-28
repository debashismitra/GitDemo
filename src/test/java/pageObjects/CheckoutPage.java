package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By productName=By.xpath("//p[@class='product-name']");
	By quantity=By.xpath("//p[@class='quantity']");
	By applyButton=By.xpath("//button[@class='promoBtn']");
	By placeOrder=By.xpath("//button[text()='Place Order']");
	By cartBag=By.xpath("//a[@class='cart-icon']");
	By checkOutButton=By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By promoCode=By.xpath("//input[@class='promoCode']");
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public String getQuantity() {
		return new WebDriverWait(driver,40).until(ExpectedConditions.visibilityOfElementLocated(quantity)).getText();
	}
	
	public boolean isApplyEnabled() {
		return new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(applyButton)).isDisplayed();
	}

	public boolean isPlaceOrderEnabled() {
		return new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(placeOrder)).isDisplayed();
	}
		
	public void proceedToCheckout() {
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public void enterPromoDode( String 	code) {
		driver.findElement(promoCode).sendKeys(code);
	}
	
	public void placeOrder() {
		driver.findElement(placeOrder).click();
	}
}
