Feature: Zero Bank - Purchase foreign currency cash

The Zero Bank app has a feature to buy foreign currency cash if you are travelling to a specific country. 
This feature will help the travellers to purchase the native currency much earlier and faster.
Showing the current selling rate will help travellers to understand the conversion rate for one local currency to USD.

Rule: The conversion amount will depend on the daily sell rate of the selected currency

    Example: Displaying the current selling rate
              
      Given I am in the Purchase Foreign Currency page
  		And I select the currency type as "GBP"
      Then the current selling rate for the "GBP" equvialent to USD should be displayed