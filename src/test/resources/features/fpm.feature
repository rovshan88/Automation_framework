@fpm
Feature: Verify Loading morning position button is enable and functional



  @fpm-1
  Scenario: Verify Loading Morning position button displayed and enabled
    Given I am on the Investor Portfolio Page
    When I click on Loading Morning Position
    Then I verify I am on Load Morning Position page