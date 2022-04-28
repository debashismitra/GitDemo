package stepDefinitions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestContextSetUp;

public class CheckoutPageStepDefinition {
	WebDriver driver;
	String homeWindow,childWindow;
	WebDriverWait wait;
	String keyword;
	String homeProductName;
	TestContextSetUp testContextSetUp;
	CheckoutPage checkoutPage;
	LandingPage landingPage;
	
	public CheckoutPageStepDefinition(TestContextSetUp testContextSetUp) {
		this.testContextSetUp=testContextSetUp;
    	this.checkoutPage= testContextSetUp.ObjectManager.getCheckoutPage();
	}

    @Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws Throwable {
    	landingPage=testContextSetUp.ObjectManager.getLandingPage();
    	landingPage.addToCart();
    	checkoutPage.proceedToCheckout();
    	Thread.sleep(3000);
    	String cartProductname=checkoutPage.getProductName().split("-")[0].trim();
    	
    	Assert.assertEquals(cartProductname, testContextSetUp.homeProductName);
    	
    	String cartQuantity=checkoutPage.getQuantity();
    	Assert.assertEquals(cartQuantity, testContextSetUp.landingItemNumber);
    	Assert.assertEquals(true, checkoutPage.isApplyEnabled());
    	Assert.assertEquals(true, checkoutPage.isPlaceOrderEnabled());
    	
    	
    }
    
    @And("^verify user has ability to enter promo code and place the order$")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws Throwable {
    	checkoutPage.enterPromoDode("abcd");
    	checkoutPage.placeOrder();
    }
}
