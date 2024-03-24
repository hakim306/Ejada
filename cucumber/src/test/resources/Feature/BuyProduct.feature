Feature: Buy Product.
	Scenario: Check that buy product functionality working as expected.
		Given user on product page.
		When user Add the most expensive two products to your cart
		And Click on cart logo
		Then User will be navigated to Cart Page.
		And click on checkout button.
		Then user will be navigated to checkout page.
		And Fill information form and click on continue button
		Then user will be navigated to overview page.
		And click on finish button.
		Then successfull message will appears.
		