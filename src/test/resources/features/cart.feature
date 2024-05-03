@SmokeTest
Feature: Cart

  Background:
    Given I am on the sign-in page
    When I enter 'jgedertceva@gmail.com' and 'MasterfieldTest2024'
    Then Login was successful

  Scenario Outline: User adds products to the cart and remove them
    Given I select search field
    When I enter '<item>'
    And The page with search results is shown
    And I add '<number>' of products to cart
    Then the cart contains the selected '<number>' items
    And Remove all the items from the cart
    And Cart is empty
    Examples:
      | item   | number |
      | tomato | 7      |
      | glass  | 3      |
