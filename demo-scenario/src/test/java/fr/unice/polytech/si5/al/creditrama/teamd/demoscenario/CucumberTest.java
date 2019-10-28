package fr.unice.polytech.si5.al.creditrama.teamd.demoscenario;


import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * To run cucumber test.
 */
@RunWith(CucumberReportRunner.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {"pretty", "json:target/cucumber-report.json"})
public class CucumberTest {

}