package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.cucumber;

import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.CucumberConfiguration;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.World;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank.Client;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class ManageRecipientsStepDefs implements En {
    private World world;
    private Client alice;
    private Client bob;

    public ManageRecipientsStepDefs(World world) {
        this.world = world;
    }

    @Given("Alice and Bob, clients of CreditRama")
    public void aliceAClientOfCreditRama() {
        alice = world.createClient("alice", "password", "alice@gmail.com");
        bob = world.createClient("bob", "password", "bob@gmail.com");

        CucumberConfiguration.alice = this.alice;
        CucumberConfiguration.bob = this.bob;
    }

    @When("Alice adds Bob as a new recipient")
    public void aliceAddsBobAsANewRecipient() {
        world.getBankControllerApi().addRecipient(alice.getUserId(), bob.getBankAccounts().get(0).getBankAccountId());
    }

    @Then("Alice has a new recipient")
    public void aliceHasANewRecipient() {
        List<Integer> recipients = world.getBankControllerApi().getRecipients(alice.getUserId());
        assertTrue(recipients.contains(bob.getBankAccounts().get(0).getBankAccountId()));
    }

    @And("With a recipient \\(Bob)")
    public void withARecipient() {
        List<Integer> recipients = world.getBankControllerApi().getRecipients(alice.getUserId());
        if (recipients.isEmpty()) {
            world.getBankControllerApi().addRecipient(alice.getUserId(), bob.getBankAccounts().get(0).getBankAccountId());
        }
        assertTrue(world.getBankControllerApi().getRecipients(alice.getUserId()).contains(bob.getBankAccounts().get(0).getBankAccountId()));
    }

    @When("Alice removes a recipient, Bob")
    public void aliceRemovesARecipientBob() {
        world.getBankControllerApi().deleteRecipient(alice.getUserId(), bob.getBankAccounts().get(0).getBankAccountId());
    }

    @Then("Alice does not have Bob as recipient")
    public void aliceDoesNotHaveBobAsRecipient() {
        List<Integer> recipients = world.getBankControllerApi().getRecipients(alice.getUserId());
        assertTrue(recipients.isEmpty());
    }
}
