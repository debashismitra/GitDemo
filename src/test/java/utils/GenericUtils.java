package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	WebDriver driver;
	String childWindow;
	String homeWindow;
	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void switchToChildWindow(String homeWindow) {
        Set<String> childWindows=driver.getWindowHandles();
        Iterator<String> it=childWindows.iterator();
        while(it.hasNext()){
        	childWindow=it.next();
        	if(!childWindow.equalsIgnoreCase(homeWindow)) {
        		driver.switchTo().window(childWindow);
        	}
        }
	}
	
	public void closeBrowser() {
		driver.quit();
	}

}
