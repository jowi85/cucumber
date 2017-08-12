import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty"},
        features = {"/users/Josephmiller/Projects/cucumber/src/test/resources/giphy_login.feature"}
)

public class giphy_testRunner {public class runTest {}}