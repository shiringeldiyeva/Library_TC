Feature:Library app login feature
  As a user, I should be able to login to the library app.

  Scenario Outline: verify both Students and librarians  login

    Given the user login as a "<role>"
    Then the user on  "<page>"

    Examples:
      | role      | page      |
      | student   | Books     |
      | librarian | Dashboard |


