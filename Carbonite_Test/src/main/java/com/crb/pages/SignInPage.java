package com.crb.pages;

import org.openqa.selenium.support.PageFactory;

import com.crb.base.BasePage;

public class SignInPage extends BasePage{
	
	public static String title ="Carbonite Login | Carbonite";
	
	 public SignInPage() {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public String getPageTitle() {
			return driver.getTitle();
		}
	  
	  

}
