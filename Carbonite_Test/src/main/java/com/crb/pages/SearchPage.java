package com.crb.pages;

import org.openqa.selenium.support.PageFactory;

import com.crb.base.BasePage;

public class SearchPage extends BasePage{

	public static String title ="Search";
	
	 public SearchPage() {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public String getPageTitle() {
			return driver.getTitle();
		}
}
