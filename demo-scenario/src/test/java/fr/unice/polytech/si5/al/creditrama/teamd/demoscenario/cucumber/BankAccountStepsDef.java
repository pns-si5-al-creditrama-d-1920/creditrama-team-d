package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.cucumber;

import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.BasicAuthRequestInterceptor;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.World;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank.BankAccount;
import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank.Client;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BankAccountStepsDef {
    private World world;
    private Client alice;

    public BankAccountStepsDef(World world) {
        this.world = world;
    }

    @Given("Alice, a client of CreditRama")
    public void aliceAClientOfCreditRama() {
        this.alice = world.createClient("alice", "password", "alice@gmail.com");
    }

    @When("Alice logs in")
    public void aliceLogsIn() {
        Map<String, String> details = new HashMap<>();
        details.put("grant_type", "password");
        details.put("username", alice.getUsername());
        details.put("password", "password");
        String token = world.getLoginControllerApi().getToken(details).getAccessToken();
        System.out.println("token = " + token);
        BasicAuthRequestInterceptor.token = token;
    }

    @Then("Alice can see the balance of her bank account")
    public void aliceCanSeeTheBalanceOfHerBankAccount() {
        List<BankAccount> aliceAccounts = world.getBankControllerApi().getMyBankAccounts(alice.getUserId());
        assertEquals(1, aliceAccounts.size());
        assertEquals(100.0, aliceAccounts.get(0).getBalance(), 0.0);
    }
}
