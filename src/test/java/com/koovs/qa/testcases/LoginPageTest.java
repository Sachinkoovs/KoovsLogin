package com.koovs.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.koovs.qa.base.TestBase;
import com.koovs.qa.pages.HomePage;
import com.koovs.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginpage.validateLoginPageTitle(); 
		Assert.assertEquals(title, "Koovs.com :Login Customer");
	}
	 
	
	@Test(priority=2)
	public void koovsLogoImageTest() {
		boolean flag = loginpage.validateKoovsImage();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(3000);

		loginpage.ClickOnMyAccountBtn();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.koovs.com/myaccount/view/profile");
	}

	
	@Test(priority=4)
	public void loginEmailValidationTest() throws InterruptedException {
		
		
		loginpage.ClickOnMyAccountBtn();
		loginpage.loginBtn.click();
		String text = loginpage.GetEmailErrorText();
		Assert.assertEquals("Please enter valid email", text);
	}
	
	
	@Test(priority=5)
	public void loginPasswordValidationBtn() throws InterruptedException {
		 loginpage.loginEmail(prop.getProperty("username"));
		loginpage.loginBtn.click();
		String text = loginpage.GetPasswordErrorText();
		Assert.assertEquals("Please enter valid password", text);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
