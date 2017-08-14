import cucumber.api.java.en.Given;

public class common_steps {

    @Given("^Geckodriver executable configured$")
    public void setGeckoDriver() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/geckodriver");
    }

    @Given("^Chromedriver executable configured$")
    public void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/chromedriver");
    }

}