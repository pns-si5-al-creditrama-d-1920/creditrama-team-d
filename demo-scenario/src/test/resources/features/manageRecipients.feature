Feature: Manage recipients of a Creditrama's client

  Scenario: As a customer, I want to be able to manage my recipients (1)
    Given Alice and Bob, clients of CreditRama
    When Alice adds Bob as a new recipient
    Then Alice has a new recipient

  Scenario: As a customer, I want to be able to manage my recipients (2)
    Given Alice and Bob, clients of CreditRama
    And With a recipient (Bob)
    When Alice removes a recipient, Bob
    Then Alice does not have Bob as recipient