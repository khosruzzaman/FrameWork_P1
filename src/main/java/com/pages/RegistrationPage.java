package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class RegistrationPage extends TestBase {

	//PAGE FACTORY / OBJECT REPOSITORY
	
	@FindBy(xpath = "//*[@id='dLabellogin']/span")
	WebElement login_Source_Button;
	
	@FindBy(xpath = "//*[@id='jqSignup']")
	WebElement signup_Button;
	
	@FindBy(xpath = "//button/span")
	WebElement current_User_name;
	
	@FindBy(xpath = "//*[@id='txtEmail']")
	WebElement email_fild;
	
	@FindBy(xpath = "//*[@placeholder='User Name *']")
	WebElement user_Name;
	
	@FindBy(css = "#txtPassword")
	WebElement password_1;
	
	@FindBy(css = "#txtCnfPassword")
	WebElement confirm_Pssword;
	
	@FindBy(xpath = "//*[name='txtFirstName']")
	WebElement first_Name;
	
	@FindBy(xpath = "//*[name='txtLastName']")
	WebElement last_name;
	
	@FindBy(xpath = "//*[name='custom_field_2']")
	WebElement address;
	
	//Initialized page factory
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validatePageTitle() {
		login_Source_Button.click();
		signup_Button.click();
		String pageTitle = driver.getTitle();
		System.out.println("The Login Page Title is : "+ pageTitle);
		return pageTitle;
	}
	
	public void insertNewUserDetails(String email, String userName, String pass, 
			String con_pass, String firstName, String lastName, String addr) {
		
		login_Source_Button.click();
		signup_Button.click();
		email_fild.sendKeys(email);
		user_Name.sendKeys(userName);
		password_1.sendKeys(pass);
		confirm_Pssword.sendKeys(con_pass);
		first_Name.sendKeys(firstName);
		last_name.sendKeys(lastName);
		address.sendKeys(addr);	
	}
	
	
	public String validateCurrentUserName() {
		String currentUser = current_User_name.getText();
		System.out.println("Logged User Name is :"+currentUser);
		return currentUser;
	}
	
	
	
	
	
	
	
	
	
	
}
