package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.cucumber;

import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.World;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank.BankAccount;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank.BankTransaction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.CucumberConfiguration.alice;
import static fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.CucumberConfiguration.bob;
import static org.junit.Assert.assertEquals;

public class TransferToRecipientStepsDef {
    private World world;

    public TransferToRecipientStepsDef(World world) {
        this.world = world;
    }

    @Given("Alice with a positive balance on her bank account")
    public void aliceWithAPositiveBalanceOnHerBankAccount() {
        alice = world.createClient("alice", "password", "alice@gmail.com");
        assertEquals(100.0, world.getBankControllerApi().getMyBankAccounts(alice.getUserId()).get(0).getBalance(), 0.0);
        bob = world.createClient("bob", "password2", "bob@gmail.com");
    }

    @When("Alice makes a transfer to her recipient Bob")
    public void aliceMakesATransferToHerRecipientBob() {
        List<BankAccount> alicesBankAccounts = world.getBankControllerApi().getMyBankAccounts(alice.getUserId());
        List<BankAccount> bobsBankAccounts = world.getBankControllerApi().getMyBankAccounts(bob.getUserId());

        world.getBankControllerApi().addRecipient(alice.getUserId(), bobsBankAccounts.get(0).getBankAccountId());

        BankTransaction transaction = BankTransaction.builder()
                .sourceId(alicesBankAccounts.get(0).getBankAccountId())
                .destinationId(bobsBankAccounts.get(0).getBankAccountId())
                .amount(50.0)
                .build();
        world.getBankControllerApi().transfer(alice.getUserId(), transaction);
    }

    @Then("Bob receives money from Alice's account")
    public void bobReceivesMoneyFromAliceSAccount() {
        List<BankAccount> alicesBankAccounts = world.getBankControllerApi().getMyBankAccounts(alice.getUserId());
        List<BankAccount> bobsBankAccounts = world.getBankControllerApi().getMyBankAccounts(bob.getUserId());
        List<BankTransaction> bobsTransactions = world.getClientControllerApi().getUserById(bob.getUserId()).getTransactions();

        assertEquals(150.0, bobsBankAccounts.get(0).getBalance(),0.0);
        assertEquals(50.0, alicesBankAccounts.get(0).getBalance(),0.0);
        assertEquals(alicesBankAccounts.get(0).getBankAccountId(), bobsTransactions.get(0).getSourceId());
    }
}
