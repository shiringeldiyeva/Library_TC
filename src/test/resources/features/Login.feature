Feature:Library app login feature
  As a user, I should be able to login to the library app.
  And dashboard should be displayed.
  Accounts are : librarian, student
  Background: User is already in login page
    Given user is on the login page

  @librarian @student
  Scenario: Login as librarian
    When user enters librarian username
    And user enter librarian password
    Then user should see dashboard

  @student
  Scenario: Login as student
    When user enters student username
    And user enters student password
    Then user should see dashboard
