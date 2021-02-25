Feature: search books
  As a students, I should be able to search
  books with different categories.

  Scenario: search books by all categories
    Given the user is on the homepage
    When the user changes the category
    Then the user sees the result of chosen category
