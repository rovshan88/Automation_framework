@web, @regression, @verify,
Feature: Verify invalid credential

  Background:

  Given I am om homepage

    @verify-1
      Scenario: Verify individual day temp timeline
      Given I am on DarkSky Home Page
      When I expand todays timeline
      Then I verify lowest and highest temp is displayed correctly

    @verify-2
    Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
      Given I am on DarkSky Home Page
      Then I verify current temp is not greater or less then temps from daily timeline

      @verif-3

      Scenario: Verify timline is displayed in correct format
        Given I am on DarkSky Home Page
        Then I verify timeline is displayed with two hours incremented









