@SmokeTest
Feature: Language Change

  Scenario Outline: Language can be changed to English and to Hungarian as well
    Given language is set to '<currentLanguage>'
    When I change language to '<newLanguage>'
    Then language is changed to '<expectedLanguage>'

    Examples:
      | currentLanguage | newLanguage | expectedLanguage |
      | hungarian       | english     | english          |
      | english         | hungarian   | hungarian        |
