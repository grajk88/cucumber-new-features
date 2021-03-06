Feature: Zero Bank - Purchase foreign currency cash
  
  In order to purchase foreign currency
  As a valid customer of Zero Bank
  I want to have a feature to purchase different types of currencies
  
  Scenario: Calculate conversion cost from USD to GBP
  Given I am in the Purchase Foreign Currency page
  And I select the currency type as "Great Britain (pound)"
  When I try to calculate the conversion cost for "100" USD
  Then I should be displayed with the conversion amount with "Great Britain (pound)"
  
  Scenario Outline: Calculate conversion cost from USD to a selected currency type
  Given I am in the Purchase Foreign Currency page
  And I select the currency type as "<currencyType>"
  When I try to calculate the conversion cost for "<usdAmount>" USD
  Then I should be displayed with the conversion amount with "<currencyType>"
  
  Examples:
	|currencyType|usdAmount|
	|Australia (dollar)|100|
	|Canada (dollar)|50|
	|Switzerland (franc)|75|
	|Denmark (krone)|100|
	|New Zealand (dollar)|1200|