package org.Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base{
	private static Logger log =	LogManager.getLogger(validateTitle.class.getName());

	@BeforeTest
	public void initilizer() throws Exception {
		driver=initializeDriver();
		log.info("driver is initilized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to login page");

	}
	
	@Test
	public void basePageNavigation() throws Exception {
		Thread.sleep(2000);
		LandingPage lp = new LandingPage(driver);
		lp.getUsername().sendKeys("admin");
		Thread.sleep(1000);

		lp.getPassword().sendKeys("admin123");
		Thread.sleep(1000);

		lp.btnLogin().click();
		Thread.sleep(1000);

		HomePageObjects hpo = new HomePageObjects(driver);
		//System.out.println(hpo.getTitle().getText());
		Assert.assertEquals(hpo.getTitle().getText(), "Dashboard");
		log.info("successfully validated text message");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		driver=null;
	}

}
