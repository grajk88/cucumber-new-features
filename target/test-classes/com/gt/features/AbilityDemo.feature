Ability: Zero Bank - Purchase foreign currency cash

  Scenario Template: Buy multiple foreign currencies
  
  Given I am in the Purchase Foreign Currency page
  And I select the currency type as "<currencyType>"
  When I try to calculate the conversion cost for "<usdAmount>" USD
  Then I should be displayed with the conversion amount with "<currencyType>"
 
  Scenarios: 
  |currencyType	|usdAmount|
	|AUD					|100			|
	|CAD					|50				|
	|GBP					|1200			|