package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.RegistrationPage;
import com.utill.Utility;

public class RegistrationPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	RegistrationPage registrationPage;
	Utility utility;
	public String sheetName = "NewUser1";

	@BeforeMethod
	public void setUp() {
		initialization();
		utility = new Utility();
		loginPage = new LoginPage();
		homePage = new HomePage();
		registrationPage = new RegistrationPage();
	}

	@Test
	public void validatPageTitleTest() {
		String title = registrationPage.validatePageTitle();
		Assert.assertEquals(title, "Register Now", "Page title doesnt matched!!");
	}

	@DataProvider
	public Object[][] getDatafromExcel() {
		Object[][] data = utility.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getDatafromExcel")
	public void insertNewUserDetailsTest(String email, String userName, String pass, String con_pass, String firstName,
			String lastName, String addr) {
		registrationPage.insertNewUserDetails(email, userName, pass, con_pass, firstName, lastName, addr);
		registrationPage.validateCurrentUserName();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
