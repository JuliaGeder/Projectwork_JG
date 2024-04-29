Feature: Login

    Scenario: User supplies incorrect credentials
      Given I am on the sign-in page
      When I enter 'qwerty@gmail.com' and '12345'
      Then Login was unsuccessful and error message was shown



