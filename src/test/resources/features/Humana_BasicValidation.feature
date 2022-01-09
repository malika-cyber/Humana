Feature: Basic Validation

  Background:
    Given the user is on the "Humana" homepage

    Scenario: Title Verification
      Then verify title contains "Find the Right Health Insurance"

    Scenario: Search button Verification
      When the user executes the searches for "find a doctor" in "Search" field
      And the user clicks on "Search" button
      Then verify that user see "Search Results"

    Scenario: Search function Verification
      When the user clicks on "Search for Plans"
      And the user clicks on "Find a doctor" under "Medicaid"
      And the user enters search criteria "Distance" 15 miles and "Zip Code" 60026
      And the user select a lookup method "Coverage Type" "Medicaid"
      Then the user see error message "We're sorry, there are no plans of this coverage type available in your ZIP code.
