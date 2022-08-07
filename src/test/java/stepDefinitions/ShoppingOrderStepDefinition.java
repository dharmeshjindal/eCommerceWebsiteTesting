package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddItemToCart;
import pages.HomePage;
import pages.ItemsInCart;

public class ShoppingOrderStepDefinition extends TestBase {

	HomePage homepage;
	AddItemToCart addnewItem;
	ItemsInCart itemsInCart;
	
	
	//Add ITem to the Cart
	
	@Given("Login into App with Username as {string} and Password as {string}")
	public void login_into_app_with_username_as_and_password_as(String username, String password) throws InterruptedException {
		initialize();
//		homepage = new HomePage();
//		homepage.LoginToPage(username,password);
		
	}
	
//	@When("Add an item to cart")
//	public void add_an_item_to_cart() throws InterruptedException {
//		addnewItem = new AddItemToCart();
//		addnewItem.addFirstItemToCart();
//		addnewItem.BackToHomePage();
//		addnewItem.addSecondItemToCart();
//		
//	}
	
	@When("Add an item to cart")
	public void add_an_item_to_cart() throws InterruptedException {
		addnewItem = new AddItemToCart();
		String item1 = "Sony xperia z5";
		String item2 = "Nexus 6";
		addnewItem.selectItemsFromHomePage(item1);
		addnewItem.BackToHomePage();
		addnewItem.selectItemsFromHomePage(item2);
	}
	
	@Then("Items must be added to cart")
	public void items_must_be_added_to_cart() throws InterruptedException {
		itemsInCart = new ItemsInCart();
		System.out.println("First Items in the Cart : " + itemsInCart.cartDetails()[0]);
		System.out.println("Second Items in the Cart : " + itemsInCart.cartDetails()[1]);
	}
	
	//Delete an item
	
	@When("List of Items should be available in cart")
	public void list_of_items_should_be_available_in_cart() throws InterruptedException {
		itemsInCart = new ItemsInCart();
		System.out.println("Number of Items in the Cart before Deleting an Item : " + itemsInCart.cartSize());
	}
	@Then("Delete an item from Cart")
	public void delete_an_item_from_cart() throws InterruptedException {
		itemsInCart = new ItemsInCart();
		itemsInCart.deleteItemFromCart();
	}


	
	
	
//Place Order
		

	
	@Given("Items should be available in Cart")
	public void items_should_be_available_in_cart() throws InterruptedException {
		itemsInCart = new ItemsInCart();
		System.out.println("Number of Items in the Cart to Place Order : " + itemsInCart.cartSize());
	}
	@When("Place Order")
	public void place_order() throws InterruptedException {
		
		itemsInCart = new ItemsInCart();
		itemsInCart.placeOrder();
	  
	}
	@Then("Purchase Items")
	public void purchase_items() throws InterruptedException {
	   
		itemsInCart = new ItemsInCart();
		itemsInCart.purchaseItems();
		
		homepage.logOut();
		
	}
	
	@After
	public void attachScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			TakesScreenshot screen = (TakesScreenshot)driver;
			File file = screen.getScreenshotAs(OutputType.FILE);
			byte[] imgByte = FileUtils.readFileToByteArray(file);
			scenario.attach(imgByte, "image/png", "image1");
		}
	}
}
