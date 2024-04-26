Feature: Language Change

  Background:
    Given I open the main page
    And I accept cookies
    And I am logged in as a customer

  Scenario Outline: User adds products to the cart
    Given I select search field
    When I enter '<item>'
    And The page with search results is shown
    And I select '<number>' product
    And I add it to favorites
    Then the my favorites list contains the selected item/s
    Examples:
      | item       | number |
      | tomato     | 5      |
      | glass      | 10     |

  Scenario: User removes products to the my favorites list
    Given My favorites list contains the selected item/s
    When I press remove button
    Then the selected item is removed from my favorites list