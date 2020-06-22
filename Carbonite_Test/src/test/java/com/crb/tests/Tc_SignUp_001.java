package com.crb.tests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crb.base.BasePage;
import com.crb.pages.*;
import com.crb.util.XLUtil;


public class Tc_SignUp_001 extends BasePage{

	SignUpPage signUp;
	DownloadPage downloadPage;
	

	public Tc_SignUp_001() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {

		logger.info("..........Sign Up Test Execution Started..........");
		initialize();
		signUp = new SignUpPage();
		signUp.closeNoticeWindow();

	}

	@Test(priority = 1)
	public void signUpPageTitleTest() {
		logger.info("..........Sign Up - First Test....VerifyTitle......");

		String pageTitle = signUp.getPageTitle();
		Assert.assertEquals(pageTitle, SignUpPage.title);

	}

	@Test(priority = 2 , dataProvider="signUpData" )
	public void validateSignUpFormTest(String email ,String confirmEmail, String password , String confirmPassword , String Country) {
		logger.info("..........Sign Up - Second Test....FormFill......");

		logger.info("... Filling signUp form ... ");
		signUp.fillForm(email, confirmEmail, password, confirmPassword);
		signUp.countrySelection(Country);


		logger.info("... validating sign up data ... ");
		if(!email.equalsIgnoreCase(confirmEmail)) {
			Assert.assertTrue(false, "Email doesn't match confirm Email");  //Email should be case-insensitive
		}

		if(!password.equals(confirmPassword)) {
			Assert.assertTrue(false, "Password doesn't match confirm Password"); //Password should be case-sensitive
		} 

		signUp.click_mail_subcription_checkbox();
		//signUp.click_captcha();         //captcha can't be automated using selenium

		
/*
		try {   // static wait to enter the captcha details manually
			Thread.sleep(15000);   
		} catch (InterruptedException e) {
           e.printStackTrace();
		}
		 downloadPage = signUp.click_submit();    
		 Assert.assertEquals(downloadPage.getPageTitle(), DownloadPage.title, "sign Up failed");
		 
*/		 
	}


	@DataProvider(name="signUpData")
	String[][] getData() throws IOException{
		logger.debug("reading data from excel file :" + prop.getDataFilePath());
		return (XLUtil.getData(prop.getDataFilePath(), prop.getSignUpDataSheetName()));

	}

	@AfterMethod(enabled=true)
	void tearDown() throws InterruptedException {
		driver.quit();
		logger.info("..........Sign Up Test Execution Finished..........");

	}

}
