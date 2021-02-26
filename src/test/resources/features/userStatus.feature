Feature: user status

  Scenario: verify user status
    Given the user (Librarian) in the homepage
    When the user clicks users module
    And the user click Status dropdown
    Then the user should see the following options

      | ACTIVE   |
      | INACTIVE |
