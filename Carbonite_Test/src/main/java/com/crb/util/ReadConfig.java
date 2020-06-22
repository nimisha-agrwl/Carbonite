package com.crb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	 Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configurations/config.properties");
	    try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
	    } 
	    catch (FileNotFoundException e) {
	    	System.out.println("exception is : "+e);
		} catch (IOException e) {
			System.out.println("exception is : "+e);
		}
	
	}
	
	public String getApplicationURL() {
		return ( pro.getProperty("url"));
	}
	
	public String getBrowswer() {
		return ( pro.getProperty("browser"));
	}
	
	
	public String getChromePath() {
		return ( pro.getProperty("chromeDriverPath"));
	}
	
	public String getFireFoxPath() {
		return ( pro.getProperty("firefoxDriverPath"));
	}
	
	public String getDataFilePath() {
		return ( pro.getProperty("dataFile"));
	}
	
	public String getSignUpDataSheetName() {
		return ( pro.getProperty("signUpDataSheet"));
	}
	
	
	

}
