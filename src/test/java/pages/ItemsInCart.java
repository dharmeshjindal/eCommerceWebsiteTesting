package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ItemsInCart extends TestBase{

	@FindBy(xpath = "//a[text()='Cart']")
	WebElement CartDetails;
	
	@FindBy(xpath = "//button[@class='btn btn-success']")
	WebElement PlaceOrderButton;
	
	
	//Initialize Driver
	
	public ItemsInCart() {
		PageFactory.initElements(driver, this);
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
	
	public void placeOrder() throws InterruptedException {
		
		Thread.sleep(2000);
		
		PlaceOrderButton.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Lucknow");
		driver.findElement(By.xpath("//input[@id='card']")).sendKeys("1111 0000 1010"); 
		driver.findElement(By.xpath("//input[@id='month']")).sendKeys("07");
		driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2022");
		driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();
		
		Thread.sleep(2000);
		
				
	}
	
	public void purchaseItems() throws InterruptedException {
		
		
		Thread.sleep(2000);
		
		String successHeader = driver.findElement(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']/h2")).getText();
		String purchaseDetails = driver.findElement(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']/p")).getText();
		
		System.out.println("Detailes of Purchased Items : " + successHeader + "\n" + purchaseDetails );
		
		driver.findElement(By.cssSelector("button.confirm.btn.btn-lg.btn-primary")).click();
		
	}

		
		
		
}
