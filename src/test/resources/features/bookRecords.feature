Feature:book records
  As a librarian, I should be able to see book records on user page

  Background:
    Given logged in librarian
    When user clicks on the books page

  Scenario:  verify that the default record is 10
    Then user should be able to see show record is 10

  Scenario: Show records for count options
    Then below count options should be able

      | 5     |
      | 10    |
      | 15    |
      | 50    |
      | 100   |


