package com.crb.pages;

import org.openqa.selenium.support.PageFactory;

import com.crb.base.BasePage;

public class SupportPage extends BasePage{
	
	public static String title ="Customer Support and Technical Assistance | Carbonite";
	
	 public SupportPage() {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public String getPageTitle() {
			return driver.getTitle();
		}

}
