Feature: Books search

Scenario: Find an existent book
  Given an existent book
  When I search by its Id
  Then I should get the book details

Scenario: Find an existent book 2
    Given an existent book
    When I search by its Id
    Then I should get the book details