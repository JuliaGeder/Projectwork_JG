@SmokeTest
Feature: Language Change

  Background:
    Given I am on the sign-in page
    When I enter 'jgedertceva@gmail.com' and 'MasterfieldTest2024'
    Then Login was successful

  Scenario: User adds products to the cart
    Given My account page is open
    When I click on edit personal details
    And I change name to 'Julia','Geder'
    And I save changes
    Then Name 'Julia','Geder' is displayed in Personal details
