package com.crb.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crb.base.BasePage;

public class SignUpPage extends BasePage{
	
	public static String title= "Try Carbonite Computer Backup Free For 15 Days | Carbonite";

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}


	@FindBy(xpath="//input[@name='Email']")
	@CacheLookup
	WebElement email;


	@FindBy(xpath="//input[@name='confirmEmail']")
	@CacheLookup
	WebElement confirmEmail;

	@FindBy(xpath="//input[@name='Password']")
	@CacheLookup
	WebElement password;


	@FindBy(xpath="//input[@name='ConfirmPassword']")
	@CacheLookup
	WebElement confirmPassword;


	@FindBy(xpath="//select[@name='Country']")
	@CacheLookup
	WebElement country;


	@FindBy(xpath="//input[@name='GDPROptIn']")
	WebElement mail_subcribe_checkBox;


	@FindBy(xpath="//div[@class='rc-anchor-center-container']")
	WebElement captcha_checkBox;

	@FindBy(xpath="//div[@class='//recaptcha-checkbox-checkmark']")
	WebElement captcha_greenIcon;

	@FindBy(xpath="//input[contains(@class,'button sm-btn green-btn')]")
	@CacheLookup
	WebElement submit_btn;

	@FindBy(xpath="//div[@id='notice']")
	@CacheLookup
	WebElement notice_window;

	@FindBy(xpath="//button[@class='circle']")
	@CacheLookup
	WebElement notice_window_close_btn;
	
	@FindBy(xpath="//a[@id='util-nave-sign-in']")
	@CacheLookup
	WebElement signIn_btn;


	public void closeNoticeWindow() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(notice_window));
		notice_window_close_btn.click();

	}

	public void fillForm(String mail,String cMail,String pwd,String cPwd) {
		email.sendKeys(mail);	
		confirmEmail.sendKeys(cMail);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(cPwd);
	}

	public void	countrySelection(String country_name) {
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText(country_name);
	}


	public void click_mail_subcription_checkbox() {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", mail_subcribe_checkBox);

	}

	public void click_captcha() {
		driver.switchTo().frame(1);
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", captcha_checkBox);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(captcha_greenIcon));
		driver.switchTo().defaultContent();
	}

	public DownloadPage click_submit() {
		submit_btn.click();
        return new DownloadPage();  // returns landing page - download page
	}
	
	
	public SignInPage click_signIn() {
		signIn_btn.click();
        return new SignInPage();  // returns landing page - SignIn 
	}
	
}
