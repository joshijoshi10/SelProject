package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class LandingPage extends base{

	public WebDriver driver;
	
	By userName = By.cssSelector("#txtUsername");
	By password = By.cssSelector("#txtPassword");
	By btnLogin = By.cssSelector("#btnLogin");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getUsername() {
		return driver.findElement(userName);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement btnLogin() {
		return driver.findElement(btnLogin);
	}
}
