package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.TestBase;

public class AddItemToCart extends TestBase{

	

	@FindBy(xpath="(//div[@class='card h-100'])[1]/div[1]/h4/a")
	WebElement item1;
	
	@FindBy(xpath="(//div[@class='card h-100'])[2]")
	WebElement item2;
	
	@FindBy(css = "a.btn.btn-success.btn-lg")
	WebElement addToCartBtn;
	
	
	@FindBy(xpath = "//a[text()='Home ']") //(//a[@class='nav-link'])[1]
	WebElement LinkToHomePage;
	
	
	
	public  AddItemToCart() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Add Items to Cart
	public void addFirstItemToCart() throws InterruptedException {
		
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(item1).click().perform();
		Thread.sleep(2000);
		addToCartBtn.click();
		
		Thread.sleep(2000);
		
		Alert alertPopUp = driver.switchTo().alert();
		//alertPopUp.wait();
		Thread.sleep(2000);
		String itemAddedToCart = alertPopUp.getText();
		System.out.println("Pop up message : " + itemAddedToCart);
		alertPopUp.accept();
//		return itemAddedToCart;
		
		
	}
	
	
	//Link to Home Page
	public void BackToHomePage() {  
		try {
	
		
			LinkToHomePage.click();
			Thread.sleep(2000);
		}
	 catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	public void addSecondItemToCart() throws InterruptedException {
	Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(item2).click().perform();
		Thread.sleep(2000);
		addToCartBtn.click();
		
		Thread.sleep(2000);
		Alert alertPopUp = driver.switchTo().alert();
		Thread.sleep(2000);
		String itemAddedToCart = alertPopUp.getText();
		System.out.println("Pop up message : " + itemAddedToCart);
		alertPopUp.accept();
	}
	
	
		
}
