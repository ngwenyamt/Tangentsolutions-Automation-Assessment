Feature: Nationalities
  Scenario Outline: Testing Nationalities Function

    Given Login to RiseApp portal using valid "<username>" and "<password>"
    Then User navigate to Lookups > Nationalities
    And User Add a new Nationality - "<name>" and "<description>"
    And User View the Nationality
    And User Edit the added Nationality - "<editName>" and "<Editdescription>"
    And User Delete the Nationality

Examples:

    |username|password|name|description|editName|Editdescription|
    |pinkshrub@riseapp.co.za|adminadmin123|Tebogo Test Name fields|Tebogo Test Description fields|Test Edit name| Test edit description|