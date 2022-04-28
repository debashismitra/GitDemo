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
import pageObjects.OfferPage;
import utils.TestContextSetUp;

public class OfferPageStepDefinition {
	WebDriver driver;
	String homeWindow,childWindow;
	WebDriverWait wait;
	String keyword;
	String homeProductName;
	TestContextSetUp testContextSetUp;
	OfferPage offerPage;
	
	public OfferPageStepDefinition(TestContextSetUp testContextSetUp) {
		this.testContextSetUp=testContextSetUp;
		
	}

	@Then("^user searched for same shortname in offers page$")
    public void user_searched_for_same_shortname_in_offers_page() throws Throwable {
		offerPage=testContextSetUp.ObjectManager.getOfferPage();
		switchToOffersPage();
		offerPage.offerPageSearch(testContextSetUp.keyword);
    }
	
	public void switchToOffersPage() {		
		LandingPage landingPage=testContextSetUp.ObjectManager.getLandingPage();
		String homeWindow=landingPage.getHomeWindow();
		landingPage.clickTopDeal();		
		testContextSetUp.genericUtils.switchToChildWindow(homeWindow);
	}
	
	
	@And("^validate product name in offers page matches with Landing page$")
    public void validate_product_name_in_offers_page_matches_with_landing_page() throws Throwable {
        String offerProductName=offerPage.getOfferPageProductName().trim();
        if(offerProductName.equalsIgnoreCase(testContextSetUp.homeProductName)) {
        	System.out.println("PASS");
        }
        else {
        	System.out.println("FAIL");
        }
        
        Assert.assertEquals(offerProductName, testContextSetUp.homeProductName);
//        testContextSetUp.genericUtils.closeBrowser();
        
	}
}
