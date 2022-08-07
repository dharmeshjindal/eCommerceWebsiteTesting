package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{
	//Modified by Dharmesh Jindal for the first time
	//New Change done
	
	@FindBy(css = "#login2")
	WebElement Login;
	
	@FindBy(id = "loginusername")
	WebElement LoginUserName;
	
	@FindBy(id = "loginpassword")
	WebElement LoginPassword;
	
	@FindBy(css = "#logout2")
	WebElement Logout;
	
	
	
	
	//Page Factory
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

	
	//Login
	public void LoginToPage(String username, String password) throws InterruptedException {
		Login.click();
		
		Thread.sleep(2000);
		
		LoginUserName.sendKeys(username);
		LoginPassword.sendKeys(password);
		driver.findElement(By.xpath("(//button[@class = 'btn btn-primary'])[3]")).click();
		
		Thread.sleep(2000);
		WebElement userLoggedIn = driver.findElement(By.id("nameofuser"));
		if(userLoggedIn.isDisplayed())
			System.out.println("User successfully logged in : "+userLoggedIn.getText());
		
	}
	
	
	public String getPageTitle() {
			
		return driver.getTitle();
	}
	
	//Logout	
	public void logOut() throws InterruptedException {
		Thread.sleep(2000);
		Logout.click();
	}

}
