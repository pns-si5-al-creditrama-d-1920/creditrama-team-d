Feature: Make a transfer to one recipient

  Scenario: As a customer, I want to be able to transfer money from my bank account to one of my recipients
    Given Alice with a positive balance on her bank account
    When Alice makes a transfer to her recipient Bob
    Then Bob receives money from Alice's account