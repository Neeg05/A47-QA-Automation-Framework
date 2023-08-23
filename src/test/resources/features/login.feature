Feature: Login Feature
  Background: I open login page

  Scenario: Login Success
    When I enter email "neelam.gupta@testpro.io"
    And I enter password "te$t$tudent1"
    And I click submit
    Then I am logged in

   Scenario: Login Invalid Password
    When I enter email "neelam.gupta@testpro.io"
    And I enter password "wrongPassword"
    And I click submit
    Then I am not logged in

  Scenario: Login Invalid Email
    When I enter email "invalid@invalid.com"
    And I enter password "te$t$tudent1"
    And I click submit
    Then I am not logged in

  Scenario: Login Invalid Email&Password
    When I enter email "invalid@invalid.com"
    And I enter password "wrongPassword"
    And I click submit
    Then I am not logged in

  Scenario: Login Empty Email Field
    When I enter email ""
    And I enter password "te$t$tudent1"
    And I click submit
    Then I am not logged in

  Scenario: Login Empty Password Field
    When I enter email "neelam.gupta@testpro.io"
    And I enter password ""
    And I click submit
    Then I am not logged in

  Scenario: Login Empty fields
    When I enter email ""
    And I enter password ""
    And I click submit
    Then I am not logged in