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
	
	@FindBy(css = "button.page-link#next2")
	WebElement nextButton;
	
	@FindBy(xpath="(//div[@class='card h-100'])[1]/div[1]/h4/a")
	WebElement item1;
	
	@FindBy(css = "a.btn.btn-success.btn-lg")
	WebElement addToCartBtn;
	
	
	@FindBy(xpath = "//a[text()='Home ']") 
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
	
	public void addItems(String addProduct) throws InterruptedException {
		int numberOfItemsOnHomePage = itemName.size();
		System.out.println("Number of Items on Home Page : "+numberOfItemsOnHomePage);
		itemName.get(0).sendKeys(Keys.PAGE_DOWN);
		boolean nextButtonDisplayed = nextButton.isDisplayed();
		itemName.get(0).sendKeys(Keys.PAGE_UP);
		boolean flag =false;
		
		
		do {
		
			
			flag = findProduct(numberOfItemsOnHomePage,addProduct,flag);
				
			if(flag){
				
				break;
			}
			else{			
				itemName.get(0).sendKeys(Keys.PAGE_DOWN);
				nextButtonDisplayed = nextButton.isDisplayed();
				Thread.sleep(2000);
				nextButton.click();
				Thread.sleep(2000);
				numberOfItemsOnHomePage = itemName.size();
				
			}
			
		} while(nextButtonDisplayed);
	}
			
	
	
	public boolean findProduct(int numberOfItemsOnHomePage, String addProduct, boolean flag) throws InterruptedException {
		
		for(int i=0; i<numberOfItemsOnHomePage; i++ ) {
						
			if(itemName.get(i).getText().equalsIgnoreCase(addProduct)) {
				System.out.println(addProduct + " found on the Home Page at the index..."+i);
				flag= true;
				addItem(i);
				break;
			}	
			
		}

		return flag;
		
	}

	
	public void addItem(int i) throws InterruptedException {
		
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
	}
}	