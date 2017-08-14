import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class giphy_steps {

    WebDriver driver = null;

    @Given("^I am on Giphy login page$")
    public void goToGiphy() {
        driver = new FirefoxDriver();
//        uncomment line below and comment out line above if you want to use Chrome instead of Firefox
//        driver = new ChromeDriver();
        driver.get("https://www.giphy.com/login");
    }

    @When("^I enter Giphy credentials \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enterUserName(String username, String password) {
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/input[2]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/input")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).submit();
    }

    @Then("^Successful Giphy login$")
    public void successfulGiphyLogin() {
        Assert.assertTrue(elementPresent("Account Settings"));
        driver.close();
    }

    @Then("^Unsuccessful Giphy login$")
    public void unsuccessfulGiphyLogin() {
        Assert.assertTrue(elementPresent("Don't Have An Account?"));
        driver.close();
    }

    private boolean elementPresent(String message) {
        try {
            driver.getPageSource().contains(message);
            return true;
        } catch (NoSuchElementException e) {return false;}
    }

}
