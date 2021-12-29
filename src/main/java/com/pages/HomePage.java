package com.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.TestBase.TestBase;
import com.utill.Utility;

public class HomePage extends TestBase {
	Utility utility;
	// PAGE FACTORY - OBJECT'S REPOSITORY
	@FindBy(xpath = "//button[@id='dLabellogin']") 
	WebElement login_source_button;

	@FindBy(linkText = "About Us")
	WebElement about_Us;

	@FindBy(linkText = "Contact Us")
	WebElement contact_Us;

	@FindBy(linkText = "View Cart")
	WebElement verw_Cart;

	@FindBy(xpath = "//select[@name='currency_type']")
	WebElement currency_List;

	// Page Factory initialization
	public HomePage() {
		PageFactory.initElements(driver, this);
		utility = new Utility();
	}

	public String validatePageTitle() {
		String title = driver.getTitle();
		System.out.println("The title of this page is : " + title);
		return title;
	}

	public boolean validateLoginSourceButton() {
		System.out.println("Name of this Button is : " + login_source_button.getText());
		return login_source_button.isDisplayed();
	}

	public boolean validateAboutUsLink() {
		System.out.println("Name of this object is : " + about_Us.getText());
		boolean validateAboutUs = about_Us.isDisplayed();
		return validateAboutUs;
	}

	public String verifyCurrencyList() {
	
		String[] expected = { "AUD", "BRL", "GBP", "CAD", "EUR", "XOF", "INR", "JPY", "MYR", "RUB", "ZAR", "USD" };
		
		
		for(int k =0; k<expected.length; k++) {
			System.out.println("Expected Value is :"+expected);
		
		WebElement select = currency_List;
		
		List<WebElement> allOptions = select.findElements(By.xpath("option"));

		// make sure you found the right number of elements
		if (expected.length != allOptions.size()) {
			System.out.println("fail, wrong number of elements found");
			break;
		}
		
		// INR == Indian Rupee
		// make sure that the value of every <option> element equals the expected value
		for (int i = 0; i <expected.length; i++) {
			String optionValue = allOptions.get(i).getAttribute("value");

			if (optionValue.equals(expected[i])) {
				System.out.println("Expected Value of " + expected[k++] + " is Match With Actual Value of : " + optionValue);
			} else {
				System.err.println("Expected Value of " + expected[k++] + " Doesn't Match With Actual Value of : " + optionValue);
			}
		}
		return allOptions.toString();
	}
		return expected.toString();
}
}
