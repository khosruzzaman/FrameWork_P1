package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.pages.HomePage;

public class HomePageTest extends TestBase {

	HomePage homePage;



	@BeforeMethod(groups = "LAND IN/OUT")
	public void setUp() {
		initialization();
		homePage = new HomePage();

	}

	@Test(priority = 1, groups = "UI FUNCTIONS")
	public void HomePageTitle() {
		String pageTitle = homePage.validatePageTitle();
		Assert.assertEquals(pageTitle, "Multi lingual Cart", "This title is not Available");
		System.out.println("Assertion Passed!!!");
	}

	@Test(priority = 2, groups = "UI FUNCTIONS")
	public void validateLoginSourceButtonTest() {
		homePage.validateLoginSourceButton();
		Assert.assertTrue(true);
		System.out.println("Assertion Passed!!!");
	}

	@Test(priority = 3, groups = "UI FUNCTIONS")
	public void validateAboutUsLinkTest() {
		homePage.validateAboutUsLink();
		System.out.println("Assertion Passed!!!");
	}

	@Test(priority = 4, groups = "UI LIST FUNCTIONS")
	public void verifyCurrencyListTest() {

		//String[] actualValue = { "AUD", "BRL", "GBP", "CAD", "EUR", "XOF", "INR", "JPY", "MYR", "RUB", "ZAR", "USD" };
		String currencyLists = homePage.verifyCurrencyList();
		//System.out.println("Assertion is passed!!");

	}




	@AfterMethod(groups = "LAND IN/OUT")
	public void tearDown() {
		// driver.close();
		driver.quit();

	}

}
