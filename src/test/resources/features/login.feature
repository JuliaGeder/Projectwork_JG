@SmokeTest
Feature: Login

    Scenario: User supplies incorrect credentials
      Given I am on the sign-in page
      When I enter 'qwerty@gmail.com' and '12345'
      Then Login was unsuccessful and error message was shown

  Scenario: User supplies correct credentials
    Given I am on the sign-in page
    When I enter 'jgedertceva@gmail.com' and 'MasterfieldTest2024'
    Then Login was successful


