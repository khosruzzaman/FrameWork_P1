package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;
import com.utill.Utility;

public class RegistrationPage extends TestBase {

	//PAGE FACTORY / OBJECT REPOSITORY
	
	@FindBy(xpath="//*[@id='dLabellogin']")
	WebElement login_Source_Button;
	
	@FindBy(xpath = "//*[@id='jqSignup']")
	WebElement signup_Button;
	
	@FindBy(xpath = "//button/span")
	WebElement current_User_name;
	
	@FindBy(xpath ="//*[@id=\'txtEmail\']")
	WebElement email_fild;
	
	@FindBy(xpath ="//*[@id=\'txtUserName\']")
	WebElement user_Name;
	
	@FindBy(xpath ="//*[@id=\'txtPassword\']")
	WebElement password_1;
	
	@FindBy(xpath ="//*[@id=\'txtCnfPassword\']")
	WebElement confirm_Pssword;
	
	@FindBy(xpath ="//*[@id=\'txtFirstName\']")
	WebElement first_Name;
	
	@FindBy(xpath ="//*[@id=\'txtLastName\']")
	WebElement last_name;
	
	@FindBy(xpath = "//*[@placeholder='Address *']")
	WebElement address;
	
	@FindBy(xpath ="//*[@id=\'btnRegister\']")
	WebElement btn_Register;
	
	//Initialized page factory
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validatePageTitle() {
		login_Source_Button.click();
		signup_Button.click();
		String pageTitle = driver.getTitle();
		System.out.println("The Register Page Title is : "+ pageTitle);
		return pageTitle;
	}
	
	public void insertNewUserDetails(String email, String userName, String pass, 
			String con_pass, String firstName, String lastName, String addr) throws InterruptedException  {
		
		login_Source_Button.click();
		signup_Button.click();
		email_fild.sendKeys(email);
		user_Name.sendKeys(userName);
		password_1.sendKeys(pass);
		confirm_Pssword.sendKeys(con_pass);
		first_Name.sendKeys(firstName);
		last_name.sendKeys(lastName);
		address.sendKeys(addr);	
		btn_Register.click();
		Thread.sleep(5000);
		driver.navigate().back();

	}
	
	
	public String validateCurrentUserName() {
		String currentUser = current_User_name.getText();
		System.out.println("Logged User Name is :"+currentUser);
		return currentUser;
	}

	
}
