Feature: Cart

  Background:
    Given I am on the sign-in page
    When I enter 'jgedertceva@gmail.com' and 'MasterfieldTest2024'
    Then Login was successful

  Scenario Outline: User adds products to the cart
    Given I select search field
    When I enter '<item>'
    And The page with search results is shown
    And I select '<number>' product
    And I add it to cart
    Then the cart contains the selected items
    Examples:
      | item       | number |
      | tomato     | 7      |
      | glass      | 3     |


    Scenario: User removes products to the cart
      Given the cart contains the items
      When I press remove button
      Then the selected item is removed from the card