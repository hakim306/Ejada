Feature: login functioanlity.

  Background: 

  Scenario Outline: Login with invalid credentials.
    Given user naviagte to Swaglabs website
    When enter invalid username "<username>"
    And enter invalid password "<password>"
    And user click on login button
    Then an error message must appears.

    Examples: 
      | username | password |
      | test     | test     |

  Scenario: Login with valid Credentials.
    When user enter valid username "standard_user"
    And user enter valid password "secret_sauce"
    And user click on login button
    Then user automatically navigated to homepage
