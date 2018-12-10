package com.koovs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.koovs.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory:
	@FindBy(xpath="//input[@id='login-email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='login-pswd']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='button']")
	public
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'CREATE ACCOUNT')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[@src='//images.koovs.com/images/kv/koovs_logo_cpr.jpg']")
	WebElement koovslogo;
	
	@FindBy(xpath="//div[@class='hoptions user-account']")
	WebElement myAccountLink;
	
	@FindBy(xpath="//*[contains(text(),'Please enter valid email')]")
	WebElement BlankEmailValidationMsg;
	
	@FindBy(xpath="//*[contains(text(),'Please enter valid password')]")
	WebElement BlankPasswordValidationMsg;
	
	
	
	//Initialise the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		ClickOnMyAccountBtn();
		
		return driver.getTitle();
	}
	
   public void  ClickOnMyAccountBtn() {
		
	   myAccountLink.click();
		
	}
	
	
	public boolean validateKoovsImage() {
		return koovslogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
		ClickOnMyAccountBtn();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		
		return new HomePage();
		
	}
	
	public void loginEmail(String un) {
		ClickOnMyAccountBtn();
		username.sendKeys(un);
		
	}
	
	public String GetEmailErrorText() {
		return BlankEmailValidationMsg.getText();
	}

	public String GetPasswordErrorText() {
		return BlankPasswordValidationMsg.getText();
	}
	
	
}
