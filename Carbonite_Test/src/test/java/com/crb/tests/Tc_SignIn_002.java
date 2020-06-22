package com.crb.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crb.base.BasePage;
import com.crb.pages.SignUpPage;
import com.crb.pages.SignInPage;

public class Tc_SignIn_002 extends BasePage{
	
	SignUpPage signUpPage;
	SignInPage signInPage;
	
	public Tc_SignIn_002() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {

		logger.info("..........Sign In Test Execution Started..........");
		initialize();
		signUpPage = new SignUpPage();
		signInPage = signUpPage.click_signIn();

	}

	@Test(priority = 1)
	public void signUpPageTitleTest() {
		logger.info("..........Sign In - First Test....VerifyTitle......");

		String pageTitle = signInPage.getPageTitle();
		Assert.assertEquals(pageTitle, SignInPage.title);

	}
	
	@AfterMethod(enabled=true)
	void tearDown() throws InterruptedException {
		driver.quit();
		logger.info("..........Sign In Test Execution Finished..........");

	}


}
