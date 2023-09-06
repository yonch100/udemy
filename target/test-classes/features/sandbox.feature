Feature: Test different actions on a sandbox page

  Scenario: As a Test Engineer, I try out different actions on a sandbox page
    Given I navigate to the static table
    And select a value from the dropdown

  @List
  Scenario Outline: As a Test Engineer, I want to validate that a text is present inside the list.
    Given I navigate to the list page
    When I search <state> in the list
    Then I can find <city> in the list
    
    Examples:
    |state			|city				|
    |Washington	|Washington	|
		|Illinois		|Illinois		|
		|mex		|mex		|