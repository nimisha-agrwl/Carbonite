package com.crb.pages;

import org.openqa.selenium.support.PageFactory;

import com.crb.base.BasePage;

public class ContactUsPage extends BasePage {
	
	public static String title = "Contact Carbonite Customer Service | Carbonite";
	
	 public ContactUsPage() {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public String getPageTitle() {
			return driver.getTitle();
		}
}
