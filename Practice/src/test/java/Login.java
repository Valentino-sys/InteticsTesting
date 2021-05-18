import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class Login {

    private WebDriver webDriver;
    private LoginPage loginPage;
    private MainTitlePage mainTitlePage;
    private int waitingSize;
    String mainTitleText;

    public Login() {
        WebDriverManager.firefoxdriver().setup();
        this.webDriver = new FirefoxDriver();
        this.loginPage = new LoginPage(webDriver);
        this.mainTitlePage = new MainTitlePage(webDriver);
        this.waitingSize = 5;
        this.mainTitleText = "Recent updates | Goodreads";
    }


    @Given("I open login page")
    public void openPage() {
        loginPage.openLoginPage();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(waitingSize, TimeUnit.SECONDS);
    }

    @When("I click the button")
    public void clickButton() {
        loginPage.clickButton();
    }

    @When("I enter 'email' $email")
    public void enterEmail(@Named("email") String email) {
        loginPage.enterEmail(email);
    }

    @When("I enter 'password' $password")
    public void enterPassword(@Named("password") String password) {
        loginPage.enterPassword(password);
    }

    @When("I click the button Sign in")
    public void clickButtonSignIn() {
        loginPage.clickButtonSignIn();
    }

    @Then("I am on main page")
    public void mainPageTest() {
        assertThat(mainTitlePage.atMainPage(), equalTo(mainTitleText));
    }

    @Then("I check if a part of the text matches")
    public void partOfTheText() {
        assertThat(mainTitlePage.getText(), anyOf(containsString("Rec"), endsWith("ns")));
    }


    public void quit() {
        mainTitlePage.quit();
    }
}
