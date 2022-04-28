Feature: Search for Products

@search
Scenario Outline: Search Experience for product search in both Home and Offers page
Given User is on Greencart Landing Page
When user searched with Shortname <Name> and extracted actual name of product
Then user searched for same shortname in offers page
And validate product name in offers page matches with Landing page
Examples:
|Name|
|tom|
|beet|