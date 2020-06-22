package com.crb.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crb.base.BasePage;

public class TestUtil extends BasePage {

	public static long PAGE_LOAD_TIMEOUT = 5;
	public static long IMPLICIT_WAIT = 5;

	public static boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(Exception e){
			return false;
		}
	}

	
	
}
