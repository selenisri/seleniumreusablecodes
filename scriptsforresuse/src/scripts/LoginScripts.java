package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.Loginelements;

public class LoginScripts {

	WebDriver driver;
	
    
     
     String [][] data= 
	 		{
	 		 {"Admin@fieldy.co","Zaiserve@121"}, //invalid password
	 		 {"Admin@fieldy.com","Zaiserve@123"}, //invalid user id
	 		 {"Admin@fiely.co","aiserve@121"}, // both invalid
	 		 {"Admin@fieldy.co","Zaiserve@121"} //both correct
	 		 
	 	     };
	     
	     @DataProvider(name="logindata")
	     public String[][] dataprovider()
	     {
	    	 return data;
	     }
    
	 @Test(dataProvider="logindata")
	 public void Testcase(String username , String password)
	
	 {
		    System.setProperty("webdriver.chrome.driver","C:\\Users\\srira\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
	    	String baseUrl = "http://zaicrm.com/#/";  
	        driver.get(baseUrl);
	        PageFactory.initElements(driver,Loginelements.class);
	        Loginelements.username.sendKeys(username);
		    Loginelements.password.sendKeys(password);
		    Loginelements.loginbtn.click();
		    driver.quit();
		 
	 }
	 
	
	 
	 
	 
	 
	 
	}
	
	
	

