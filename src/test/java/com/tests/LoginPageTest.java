package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void validatLoginPageTitleTest() throws InterruptedException {
		loginTest();
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Multi lingual Cart", "Page title doesnt matched!!");
	}

	@Test(priority = 2)
	public void loginTest() {
		loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 3)
	public void validateUserNameTest() throws InterruptedException {
		loginTest();
		Thread.sleep(2000);
		loginPage.validateCurrentUserName();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
