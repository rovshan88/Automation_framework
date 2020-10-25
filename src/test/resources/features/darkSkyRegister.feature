@web @regression @register
Feature: Verify invalid signup Register



      @register-1
      Scenario: Verify invalid signup error message
        Given I am on the darksky Register page
        When I click on Register button
        Then I verify I am on Register page by asserting Register header
