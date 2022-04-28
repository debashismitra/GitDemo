Feature: Place the order

@checkout
Scenario Outline: Checkout Experience for product
Given User is on Greencart Landing Page
When user searched with Shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to the cart
Then user proceeds to checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order
Examples:
|Name|
|tom|
|beet|