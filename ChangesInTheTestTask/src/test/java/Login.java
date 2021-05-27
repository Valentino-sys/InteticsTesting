import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class Login {

    private WebDriver webDriver;
    private LoginPage loginPage;
    private MainTitlePage mainTitlePage;
    private BookPage bookPage;
    private MyBooksPage myBooksPage;
    private String mainTitleText;
    private String url;


    public Login() {
        WebDriverManager.firefoxdriver().setup();
        this.webDriver = new FirefoxDriver();
        this.loginPage = new LoginPage(webDriver);
        this.mainTitlePage = new MainTitlePage(webDriver);
        this.bookPage = new BookPage(webDriver);
        this.myBooksPage = new MyBooksPage(webDriver);
        this.mainTitleText = "Recent updates | Goodreads";
        this.url = "https://www.goodreads.com/book/show/";
    }


    @Given("I open login page")
    public void openPage() {
        loginPage.openLoginPage();
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


    @Given("I go to the book page 'url' $id")
    public void openBooksPage(@Named("id") String id) {
        bookPage.openBooksPage(url + id);
        bookPage.settings();

    }

    @When("I click  button want to read")
    public void clickButtonWantToRead() {
        bookPage.clickButtonWantToRead();
    }


    @Given("I go to the my books page")
    public void clickMyBooksButton() {
        bookPage.clickMyBooksButton();
    }


    @When("I check that my book is on the list")
    public void checkListBooksTest() {
        bookPage.refresh();
        assertThat(myBooksPage.booksListIsNotEmpty(), anyOf(containsString("The Fellowship of the Ring (The ")));
    }

    @When("I delete the book")
    public void deleteBook() {
        myBooksPage.clickDeleteButton();
    }

    @Then("I check that my book is not in the list")
    public void checkMyBookIsNotInTheList() {
        assertThat(myBooksPage.booksListIsEmpty(), anyOf(containsString("No matching items!")));
    }

    public void quit() {
        myBooksPage.quit();
    }

}
