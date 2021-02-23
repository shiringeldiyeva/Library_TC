Feature: Log out

  Scenario: As a user, I should be able to logout from the library app.
    Given logged in user
    When user clicks on userButton
    And user clicks on logOutButton
    Then user on the login page



