Feature: Login Feature
  Verify if user is able to Login in to the site

  @fil
  Scenario: Login as a authenticated user
    Given user is on homepage
    When user navigates to Login Page
    And user enters username and Password
    Then success message is displayed

  Scenario: Login screen throws an error if email is incorrect
    Given user is on homepage
    When user navigates to Login Page
    And user enters incorrect username and Password
    Then error message is displayed

  Scenario: Use search bar and search for shoes
    Given user is on homepage
    When user searches for shoes in the search bar
    Then user is taken to the search results