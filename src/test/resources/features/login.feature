Feature: Login

  Background:
    Given I open the main page
    And I accept cookies

    Scenario Outline: User supplies proper credentials or incorrect credentials
      Given I am on the sigh-in page
      When I enter '<username>' and '<password>'
      Then Login was successful or error message was shown
      Examples:
        |username       | password      |
        |validusername  | validpassword |
        |invalid        | invalid       |


