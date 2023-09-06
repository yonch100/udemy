
Feature: Test different actions on the static table page

	#Rule: Que reggla de negocio se validan con estos escenarios
	Rule: The user can return values from the table an validate them

  #Ejecutara background primero y posteriormente los escenarios, esto para omitir escribir siempre el primer paso en cada caso
  Background: Navigate to Table web app
    Given I navigate to the static table

  Scenario: As a Test Engineer, I want to retrieve the value of an static table
    #Given I navigate to the static table
    Then I can return the value i wanted

  Scenario: As a Test Engineer, I want to validate the static table is displayed.
    #Given I navigate to the static table
    Then I can validate the table is displayed
