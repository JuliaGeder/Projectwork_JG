Feature: Search

  Background:
    Given I open the main page
    And I accept cookies

    Scenario Outline: User receives the search results after using the search field
      Given I select search field
      When I enter '<item>'
      Then The page with search results is shown
      Examples:
        | item       |
        | tomato     |
        | sunglasses |