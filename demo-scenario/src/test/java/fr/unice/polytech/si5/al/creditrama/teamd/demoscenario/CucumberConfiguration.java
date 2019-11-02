package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario;

import fr.unice.polytech.si5.al.creditrama.teamd.demoscenario.model.bank.Client;
import io.cucumber.java.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to use spring application context while running cucumber
 */
public class CucumberConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(CucumberConfiguration.class);

    public static Client alice;
    public static Client bob;

    @After
    public void tearDown() {
        if (alice != null) {
            World.deleteClient(alice.getUserId());
        }
        if (bob != null) {
            World.deleteClient(bob.getUserId());
        }
        BasicAuthRequestInterceptor.token = null;
    }
}
