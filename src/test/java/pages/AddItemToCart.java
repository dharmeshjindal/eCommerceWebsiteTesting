package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class AddItemToCart extends TestBase{

	

	@FindBy(xpath="(//div[@class='card h-100'])[1]/div[1]/h4/a")
	WebElement item1;
	
	@FindBy(xpath="(//div[@class='card h-100'])[2]")
	WebElement item2;
	
	@FindBy(css = "a.btn.btn-success.btn-lg")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//a[text()='Cart']")
	WebElement CartDetails;
	
	@FindBy(xpath = "//a[text()='Home ']") //(//a[@class='nav-link'])[1]
	WebElement LinkToHomePage;
	
	@FindBy(css = "h1.h4")
	WebElement header;
	
	public  AddItemToCart() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Action
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
	
	
	public int cartSize() throws InterruptedException {
		
		Thread.sleep(2000);
		CartDetails.click();
		Thread.sleep(2000);
		List<WebElement> totalItemsInCart =  driver.findElements(By.xpath("//tbody[@id='tbodyid']/tr"));
		if (totalItemsInCart.size()>0) {
			System.out.println("Number of Items in Cart : "+totalItemsInCart.size());
		}
		else {
			System.out.println("Cart is Empty...");
		}
		return totalItemsInCart.size();
		
	}
	
	public String[] cartDetails() throws InterruptedException {
		CartDetails.click();
		Thread.sleep(2000);
		WebElement firstItem = driver.findElement(By.xpath("//tbody[@id = 'tbodyid']/tr[1]/td[2]"));
		WebElement secondItem = driver.findElement(By.xpath("//tbody[@id = 'tbodyid']/tr[2]/td[2]"));
		String[] itemDetails = {firstItem.getText(),secondItem.getText()};
		return itemDetails;
	}
	
	public void deleteItemFromCart() throws InterruptedException {
		driver.findElement(By.xpath("//tbody[@id = 'tbodyid']/tr[1]/td[4]/a")).click();
		Thread.sleep(2000);
	}
	
}
