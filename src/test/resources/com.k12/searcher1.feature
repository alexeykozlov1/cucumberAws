@test2

Feature: Using Library for Elements

  Background:
    And I set the following aliases:
      | SearchText         | search_form_input_homepage |
      | SearchButton       | search_button_homepage     |
      | SearchTextGoogle   | q                          |
      | GoogleSearchButton | btnK                       |
      | LinkedinInput   | session_key           |

  Scenario: Duck Duck Search Elantra Car
    Given I open the browser "ChromeHeadless"
    And I set the default explicit wait time to "10" seconds
    When I open the URL "https://duckduckgo.com"
    And I populate the "SearchText" text box with the text "elantra car 2021"
    And I click the "SearchButton" button
    Then I close the browser

  Scenario: Google Search Elantra Car
    Given I open the browser "ChromeNoImplicitWait"
    And I set the default explicit wait time to "10" seconds
    When I open the URL "https://google.com"
    And I populate the "SearchTextGoogle" text box with the text "elantra car 2021"
    And I click the "GoogleSearchButton" button
    Then I close the browser

  Scenario: linkedin
    Given I open the browser "Chrome"
    And I set the default explicit wait time to "10" seconds
    When I open the URL "https://www.linkedin.com"
    And I populate the "LinkedinInput" text box with the text "123456789"
    Then I close the browser