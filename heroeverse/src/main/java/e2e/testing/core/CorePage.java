package e2e.testing.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorePage {
	
	private int secondsToWait = 5;
	private WebDriver driver;
	
	public CorePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriverPage() {
		return driver;
	}

	public WebElement locateElement(By by) {
		waitForElement(by);
		return driver.findElement(by);
	}
	
	public void writeOn(By by, String text) {
		WebElement element = locateElement(by);
		element.clear();
		element.sendKeys(text);
	}
	
	public void click(By by) {
		waitForElement(by);
		WebElement element = locateElement(by);
		element.click();
	}
	
	public void waitForElement(By by, int secs) {
		WebDriverWait waiter = new WebDriverWait(driver, secs);
		waiter.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void waitForElement(By by) {
		waitForElement(by, secondsToWait);
	}
	
	public List<WebElement> locateElements(By by){
		try{
			waitForElement(by);
		}catch(Exception e){
			
		}
		return driver.findElements(by);
	}
	
	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		}catch (InterruptedException e) {
		}
	}
}