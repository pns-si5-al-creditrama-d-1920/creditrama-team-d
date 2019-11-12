package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.cucumber;

import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.CucumberConfiguration;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.World;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank.BankAccount;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank.Client;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class BankAccountStepsDef implements En {
    private static Logger log = Logger.getLogger(BankAccountStepsDef.class.getName());

    private World world;
    private Client alice;

    public BankAccountStepsDef(World world) {
        this.world = world;
    }

    @Given("Alice, a client of CreditRama")
    public void aliceAClientOfCreditRama() {
        alice = world.createClient("alice", "password", "alice@gmail.com");

        CucumberConfiguration.alice = this.alice;
    }

    @When("Alice logs in")
    public void aliceLogsIn() {
        log.info("Mocking logging");
    }

    @Then("Alice can see the balance of her bank account")
    public void aliceCanSeeTheBalanceOfHerBankAccount() {
        List<BankAccount> aliceAccounts = world.getBankControllerApi().getBankAccounts(alice.getUserId());
        assertEquals(1, aliceAccounts.size());
        assertEquals(100.0, aliceAccounts.get(0).getBalance(), 0.0);
    }
}
