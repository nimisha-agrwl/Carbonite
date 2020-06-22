package com.crb.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crb.util.ReadConfig;
import com.crb.util.TestUtil;

public class BasePage {
	public static WebDriver driver;
    public static ReadConfig prop;
	public static Logger logger;

	public  BasePage() {
		//setting logger
		logger = Logger.getLogger("crb");
		PropertyConfigurator.configure("log4j.properties");
        //Loading property file
		prop = new ReadConfig();

	}

	public static void initialize() {
		String browserName = prop.getBrowswer();

		if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", prop.getChromePath());	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equalsIgnoreCase("FireFox")){
			System.setProperty("webdriver.gecko.driver", prop.getFireFoxPath());	
			driver = new FirefoxDriver(); 
		}


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getApplicationURL());
	}
	
	public static void captureScreen(String tname)  {
		logger.info(" capturing failure screenshot in Screenshots folder ");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp

		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname+"-"+timeStamp + ".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
