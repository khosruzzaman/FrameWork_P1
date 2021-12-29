package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.utill.Utility;
public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static String conProp = "/Users/khosruzzaman/Desktop/NEW_PROJECTS/PNT_CLASS/MulticartAutomationSuit/src/main/java/com/configurations/config.properties";
	// Call to constractor
	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(conProp);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","/Users/khosruzzaman/Drivers/chromedriver");	
			driver = new ChromeDriver(); // 
		} else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/khosruzzaman/Drivers/geckodriver");
			driver = new FirefoxDriver();
		}else {
			driver = new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIME_OUT,);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));	
	}

}
