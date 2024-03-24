@VitaliiD
Feature: Smoke UI test for mobile application

  Background: Run mobile application
    Given User runs mobile application
    And User login via first screen menu and navigated to Home screen

  @smoke
  Scenario Outline: Login and UI navigation
    When User opens "<menuItem>" menu, use it's UI element and set value "<value>"
    Then User returns back to Home screen
    And User returns back to Login screen
    Examples:
      | menuItem         | value |
      | Slider           | 100   |
      | Vertical swiping | Jest  |
      | Wheel picker     | black |
      | Double tap       | none  |