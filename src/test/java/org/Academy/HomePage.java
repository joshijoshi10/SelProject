package org.Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class HomePage extends base{
	private static Logger log =	LogManager.getLogger(HomePage.class.getName());

	@BeforeTest
	public void initilizer() throws Exception {
		driver=initializeDriver();
		log.info("driver is initilized");

	}
	@AfterTest
	public void tearDown() {
		driver.quit();
		driver=null;
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String un, String pwd, String text) throws Exception {
		Thread.sleep(1000);
		driver.get(prop.getProperty("url"));
		log.info("Navigated to login page");
		LandingPage lp = new LandingPage(driver);
		lp.getUsername().sendKeys(un);
		Thread.sleep(1000);

		lp.getPassword().sendKeys(pwd);
		Thread.sleep(1000);
		log.info(text);
		lp.btnLogin().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0]="admin";
		data[0][1]="admin123";
		data[0][2]="user1";
		
		data[1][0]="admn";
		data[1][1]="ads";
		data[1][2]="user2";
		return data;
	}
}
