Feature: Zero Bank - Purchase foreign currency cash
  
  In order to purchase foreign currency
  As a valid customer of Zero Bank
  I want to have a feature to purchase different types of currencies
  
  Scenario: Calculate conversion cost from USD to GBP
  Given I am in the Purchase Foreign Currency page
  And I select the currency type as "GBP"
  When I try to calculate the conversion cost for "100" USD
  Then I should be displayed with the conversion amount with "GBP"
  
  Scenario Outline: Calculate conversion cost from USD to a selected currency type
  Given I am in the Purchase Foreign Currency page
  And I select the currency type as "<currencyType>"
  When I try to calculate the conversion cost for "<usdAmount>" USD
  Then I should be displayed with the conversion amount with "<currencyType>"
  
  Examples:
  |currencyType	|usdAmount|
	|AUD					|100			|
	|CAD					|50				|
	|GBP					|1200			|