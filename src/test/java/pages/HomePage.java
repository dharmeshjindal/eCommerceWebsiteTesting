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
	
	
	
	
	//Page Factory
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

	
	//Login
	public void LoginToPage() throws InterruptedException {
		Login.click();
		//driver.switchTo().alert();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("test1");
		LoginUserName.sendKeys("testuservalid");
		LoginPassword.sendKeys("Password1");
		driver.findElement(By.xpath("(//button[@class = 'btn btn-primary'])[3]")).click();
		
		Thread.sleep(2000);
		WebElement userLoggedIn = driver.findElement(By.id("nameofuser"));
		if(userLoggedIn.isDisplayed())
			System.out.println("User successfully logged in : "+userLoggedIn.getText());
		
	}
	
	//Actions
	
	//select Category
	
	//searchProduct
	

	public String getPageTitle() {
		// TODO Auto-generated method stub
		
		return driver.getTitle();
	}
	
	//compare products
	//view wishlist
	//navigate to cart
	
	//Git Changes Modified in Phase 2 Branch
	//Changes done in Master Branch

}
