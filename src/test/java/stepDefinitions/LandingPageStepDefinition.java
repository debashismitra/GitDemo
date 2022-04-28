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
import pageObjects.LandingPage;
import utils.TestContextSetUp;

public class LandingPageStepDefinition {
	WebDriver driver;
	String homeWindow,childWindow;
	WebDriverWait wait;
	String keyword;
	String homeProductName;
	TestContextSetUp testContextSetUp;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetUp testContextSetUp) {
		this.testContextSetUp=testContextSetUp;
		this.landingPage=testContextSetUp.ObjectManager.getLandingPage();
	}
	@Given("^User is on Greencart Landing Page$")
    public void user_is_on_greencart_landing_page() throws Throwable {
		Assert.assertTrue(landingPage.getLandingPageTitle().contains("GreenKart"));
    }
    
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(String strArg1) throws Throwable {
		testContextSetUp.keyword=strArg1;		
		landingPage.landingSearch(strArg1);
        Thread.sleep(3000);
        testContextSetUp.homeProductName=landingPage.getProductName().split("-")[0].trim();        
//        testContextSetUp.homeWindow=testContextSetUp.driver.getWindowHandle();
    }
	
    @And("^Added \"([^\"]*)\" items of the selected product to the cart$")
    public void added_something_items_of_the_selected_product_to_the_cart(String noOfItems) throws Throwable {
    	testContextSetUp.landingItemNumber=noOfItems;
    	landingPage.incrementProduct(noOfItems);
//    	landingPage.addToCart();
//    	landingPage.proceedToCheckout();
//    	Thread.sleep(3000);
    }
	
}
