Feature: default Info
  As a students, I should be able to see tables with default info

  Scenario:  Table columns names
    Given the user on the homepage
    Then the user should see the following column names:
      | Actions     |
      | ISBN        |
      | Name        |
      | Author      |
      | Category    |
      | Year        |
      | Borrowed By |