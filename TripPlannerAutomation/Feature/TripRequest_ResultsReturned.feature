#Author: susan.walker@accesshq.com
#Keywords Summary :
#Feature: Title of your 
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Trip Planner
  Use the Trip Planner to plot a journey from one place to another. 

#  @tag1
#  Scenario Outline: A trip request can be executed and results returned
#    Given Phileas is planning a trip
#    When he executes a trip plan from "<Station1>" to "<Station2>"
#    Then a list of trips should be provided
#Examples:
#    | Station1 | Station2 |
#    | North Sydney Station | Town Hall Station |
#    | Town Hall Station | North Sydney Station |
    
      @tag1
  Scenario: A trip request can be executed and results returned
    Given Phileas is planning a trip
    When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
    Then a list of trips should be provided
    
    