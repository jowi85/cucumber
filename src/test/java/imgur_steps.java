import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class imgur_steps {

    WebDriver driver = null;

    @Given("^I am on Imgur login page$")
    public void goToImgur() {
        driver = new FirefoxDriver();
//        uncomment line below and comment out line above if you want to use Chrome instead of Firefox
//        driver = new ChromeDriver();
        driver.get("https://www.imgur.com/signin");
    }

    @When("^I enter Imgur credentials \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enterUserName(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
    }

    @Then("^Successful Imgur login$")
    public void successfulImgurLogin() {
        Assert.assertTrue(elementPresent("It's time to upload your first image."));
        driver.close();
    }

    @Then("^Unsuccessful Imgur login$")
    public void wrongImgurPassword() {
        Assert.assertTrue(elementPresent("Your login information was incorrect."));
        driver.close();
    }

    private boolean elementPresent(String message) {
        try {
            driver.getPageSource().contains(message);
            return true;
        } catch (NoSuchElementException e) {return false;}
    }
}
