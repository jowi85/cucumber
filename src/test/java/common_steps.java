import cucumber.api.java.en.Given;

public class common_steps {

    @Given("^Geckodriver executable configured$")
    public void setGeckoDriver() {
        System.setProperty("webdriver.gecko.driver", "/users/Josephmiller/Desktop/geckodriver");
    }

}