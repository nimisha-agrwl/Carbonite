package com.crb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crb.base.BasePage;

public class DownloadPage extends BasePage {
	
	public static String title = "Download";
	public DownloadPage() {
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	@FindBy(xpath="//a[@id='util-nave-sign-in']")
	@CacheLookup
	WebElement signIn_btn;
	
	@FindBy(xpath="//a[@id='util-nav-contact']")
	@CacheLookup
	WebElement contactUs_btn;
	
	
	
	public SignInPage click_signIn() {
		signIn_btn.click();
        return new SignInPage();  // returns landing page - SignIn 
	}
	
	public ContactUsPage click_contactUs() {
		contactUs_btn.click();
        return new ContactUsPage();  // returns landing page -Contact US
	}
}
