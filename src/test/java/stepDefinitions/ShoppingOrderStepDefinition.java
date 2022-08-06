package stepDefinitions;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddItemToCart;
import pages.HomePage;

public class ShoppingOrderStepDefinition extends TestBase {

	HomePage homepage;
	AddItemToCart addnewItem;
	
	
	//Add ITem to the Cart
	
	@Given("Login into App with Username as {string} and Password as {string}")
	public void login_into_app_with_username_as_and_password_as(String string, String string2) throws InterruptedException {
		initialize();
		homepage = new HomePage();
		homepage.LoginToPage();
	}
	
	@When("Add an item to cart")
	public void add_an_item_to_cart() throws InterruptedException {
		addnewItem = new AddItemToCart();
		addnewItem.addFirstItemToCart();
		addnewItem.BackToHomePage();
		addnewItem.addSecondItemToCart();
		
	}
	@Then("Items must be added to cart")
	public void items_must_be_added_to_cart() throws InterruptedException {
		addnewItem = new AddItemToCart();
		System.out.println("First Items in the Cart : " + addnewItem.cartDetails()[0]);
		System.out.println("Second Items in the Cart : " + addnewItem.cartDetails()[1]);
	}
	
	//Delete an item
	
	@When("List of Items should be available in cart")
	public void list_of_items_should_be_available_in_cart() throws InterruptedException {
		addnewItem = new AddItemToCart();
		System.out.println("Number of Items in the Cart before Deleting an Item : " + addnewItem.cartSize());
	}
	@Then("Delete an item from Cart")
	public void delete_an_item_from_cart() throws InterruptedException {
		addnewItem = new AddItemToCart();
		addnewItem.deleteItemFromCart();
	}


	
	
	
//Place Order
		

	
	@Given("Items should be available in Cart")
	public void items_should_be_available_in_cart() throws InterruptedException {
		addnewItem = new AddItemToCart();
		System.out.println("Number of Items in the Cart to Place Order : " + addnewItem.cartSize());
	}
	@When("Place Order")
	public void place_order() throws InterruptedException {
		
		addnewItem = new AddItemToCart();
		addnewItem.placeOrder();
	  
	}
	@Then("Purchase Items")
	public void purchase_items() throws InterruptedException {
	   
		addnewItem = new AddItemToCart();
		addnewItem.purchaseItems();
		
		homepage.logOut();
		
	}
}
