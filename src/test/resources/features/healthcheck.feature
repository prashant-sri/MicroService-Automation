@healthcheck
Feature: Health check

  Scenario: Health check of Demo Micro Service
    When User attempts to check the health of deployed microservice
    Then a valid response from the service is recieved

  