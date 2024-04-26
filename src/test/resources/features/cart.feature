Feature: Cart

  Background:
    Given I open the main page
    And I accept cookies
    And I am logged in as a customer

  Scenario Outline: User adds products to the cart
    Given I select search field
    When I enter '<item>'
    And The page with search results is shown
    And I select '<number>' product
    And I add it to cart
    Then the cart contains the selected items
    Examples:
      | item       | number |
      | tomato     | 5      |
      | glass      | 10     |


    Scenario: User removes products to the cart
      Given the cart contains the item/s
      When I press remove button
      Then the selected item is removed from the card