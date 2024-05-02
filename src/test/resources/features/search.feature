@RegressionTest
Feature: Search

    Scenario Outline: User receives the search results after using the search field
      Given I select search field
      When I enter '<item>'
      Then The page with search results is shown
      Examples:
        | item       |
        | tomato     |
        | glass      |


      Scenario: The search results page shows 48 per page
        Given I select search field
        When I enter 'biscuits'
        And I click on Show more per page
        Then The page with search results is shown

  Scenario: The search page shows no results
    Given I select search field
    When I enter 'sunglasses'
    Then Zero items were found
