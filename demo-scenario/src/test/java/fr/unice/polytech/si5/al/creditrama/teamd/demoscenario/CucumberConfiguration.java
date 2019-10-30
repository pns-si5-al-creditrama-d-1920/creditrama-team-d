package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to use spring application context while running cucumber
 */
public class CucumberConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(CucumberConfiguration.class);

    /**
     * Need this method so the cucumber will recognize this class as glue and load spring context configuration
     */
    @Before
    public void setUp() {
        //LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
    }

    @After
    public void tearDown() {

    }
}
