package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


import base.TestBase;

public class AddItemToCart extends TestBase{

	
	@FindBy(css = "div.col-lg-4.col-md-6.mb-4")
	List<WebElement> PageItems;
	
	@FindBy(xpath = "(//div[@class = 'col-lg-4 col-md-6 mb-4']/div/div/h4/a)")
	List<WebElement> itemName;
	
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
	
	public void selectItemsFromHomePage(String addProduct) throws InterruptedException {
		int numberOfItemsOnHomePage = itemName.size();
		System.out.println("Number of Items on Home Page : "+numberOfItemsOnHomePage);
		
//		itemName
		boolean flag = true;
		for(int i=1; i<=numberOfItemsOnHomePage; i++ ) {
			
			
//				System.out.println("Item found on Home Page : "+ itemName.get(i).getText());
				
			if(itemName.get(i).getText().equalsIgnoreCase(addProduct)) {
				itemName.get(i).click();
				Thread.sleep(2000);
				addToCartBtn.click();
				
				Thread.sleep(2000);
				
				Alert alertPopUp = driver.switchTo().alert();
				//alertPopUp.wait();
				Thread.sleep(2000);
				String itemAddedToCart = alertPopUp.getText();
				System.out.println("Pop up message : " + itemAddedToCart);
				alertPopUp.accept();
				break;
			}

						
		}
//		if(flag) {
//			itemName.get(1).sendKeys(Keys.PAGE_DOWN);
//			Thread.sleep(2000);
//			driver.findElement(By.cssSelector("button.page-link#next2")).click();
//			Thread.sleep(2000);
//			
//			int itemsOnNextPage = itemName.size();
//			
//			for(int i=1; i<=itemsOnNextPage; i++ ) {
//				
//				
////				System.out.println("Item found on Home Page : "+ itemName.get(i).getText());
//				
//			if(itemName.get(i).getText().equalsIgnoreCase("2017 Dell 15.6 Inch")) {
//				itemName.get(i).click();
//				flag = false;
//			}
//		}
//		
//		
//	}
//	
		
}
	}
