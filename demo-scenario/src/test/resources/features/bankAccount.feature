Feature: Check the status of a bank account

  Scenario: As a customer, I want to be able to check the balance of my bank account
    Given Alice, a client of CreditRama
    When Alice logs in
    Then Alice can see the balance of her bank account