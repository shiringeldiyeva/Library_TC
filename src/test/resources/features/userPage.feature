Feature: User page
  As a librarian, I should be able to add users from users page.

  Background:
    Given logged in librarian on the users page

  Scenario:  add users with all valid info
    When user clicks on add user button
    And user fills fields with information below
      | FullName  | Mike Enigma                |
      | Password  | 147856                     |
      | Email     | miken788@gmail.com         |
      | UserGroup | Student                    |
      | Status    | ACTIVE                     |
      | StartDate | 2021-02-27                 |
      | EndDate   | 2021-05-26                 |
      | Address   | 5887Franklin ave,Boston,MA |
    And user clicks on save changes button
    Then new user should be created

  Scenario: Librarians able to close the add user window with "close" button
    When user clicks on add user button
    And user clicks on close button
    Then add user window should be closed

  Scenario: Librarians able to edit user info.
    When user clicks on edit user button
    Then edit user window is displayed

    
