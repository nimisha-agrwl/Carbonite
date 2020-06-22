package com.crb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crb.base.BasePage;

public class Header extends BasePage{
	
	 public Header() {
		  PageFactory.initElements(driver, this);
	  }
	  
		@FindBy(xpath="//a[@id='util-nave-sign-in']")
		@CacheLookup
		static WebElement signIn_btn;
		
		@FindBy(xpath="//a[@id='util-nav-contact']")
		@CacheLookup
		static WebElement contactUs_btn;
		
		@FindBy(xpath="//a[@id='util-nav-support']")
		@CacheLookup
		static WebElement support_btn;
		
		@FindBy(xpath="//a[@id='util-nav-search']")
		@CacheLookup
		static WebElement search_btn;
		
		@FindBy(xpath="//a[@id='main-nav-home-backup']")
		@CacheLookup
		static WebElement homeBackUp_btn;
		
		
		
		
		
		public static SignInPage click_signIn() {
			signIn_btn.click();
	        return new SignInPage();  // returns landing page - SignIn 
		}
		
		public static ContactUsPage click_contactUs() {
			contactUs_btn.click();
	        return new ContactUsPage();  // returns landing page -Contact US
		}
		
		public static SupportPage click_support() {
			support_btn.click();
	        return new SupportPage();  // returns landing page -Support
		}
		
		public static SearchPage click_search() {
			search_btn.click();
	        return new SearchPage();  // returns landing page -Search
		}
		
		
}
