Feature: Place Order from DemoBlaze

@AddItem
Scenario: Add items to cart
Given Login into App with Username as "testuservalid" and Password as "Password1"
When Add an item to cart
#Then Items must be added to cart


@DeleteItem
Scenario: Delete an Item
Given Login into App with Username as "testuservalid" and Password as "Password1"
When List of Items should be available in cart
Then Delete an item from Cart

@PlaceOrder
Scenario: Place Order
Given Login into App with Username as "testuservalid" and Password as "Password1"
And Items should be available in Cart
When Place Order
Then Purchase Items
