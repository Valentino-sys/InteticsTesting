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
    private ClassicBooksPage classicBooksPage;
    private String mainTitleText;
    private String classicsBooksTitleText;
    private String messageAboutAddingBook;
    private String bookTitle;
    private UrlLink url;


    public Login() {
        WebDriverManager.firefoxdriver().setup();
        this.webDriver = new FirefoxDriver();
        this.loginPage = new LoginPage(webDriver);
        this.mainTitlePage = new MainTitlePage(webDriver);
        this.bookPage = new BookPage(webDriver);
        this.myBooksPage = new MyBooksPage(webDriver);
        this.classicBooksPage = new ClassicBooksPage(webDriver);
        this.mainTitleText = "Recent updates | Goodreads";
        this.classicsBooksTitleText = "Classics";
        this.messageAboutAddingBook = "Currently Reading";
        this.url = UrlLink.URL_BOOK_PAGE;
    }


    @Given("I open login page")
    public void openPage() {
        loginPage.openLoginPage();
        bookPage.settings();
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
        bookPage.openBooksPage(url.getUrlAddress() + id);
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
        assertThat(myBooksPage.booksListIsNotEmpty(), anyOf(containsString(bookTitle)));
    }

    @When("I delete the book")
    public void deleteBook() {
        myBooksPage.clickDeleteButton();
        myBooksPage.browserNotification();
    }

    @Then("I check that my book is not in the list")
    public void checkMyBookIsNotInTheList() {
        myBooksPage.explicitWait();
        assertThat(myBooksPage.booksListIsEmpty(), anyOf(containsString("No matching items!")));
    }


    @When("I click Browse button")
    public void clickButtonBrowse() {
        mainTitlePage.clickButtonBrowse();
    }

    @When("I choose the fourth recommendation")
    public void selectingRecommendation() {
        mainTitlePage.clickButtonClassics();
    }

    @Then("I go to the classic books page")
    public void classicsBooksPageTest() {
        assertThat(classicBooksPage.atClassicBooksPage(), equalTo(classicsBooksTitleText));
    }

    @When("I select the third book from the list provided")
    public void selectThirdBook() {
        classicBooksPage.selectingBookFromTheList();
    }

    @When("I click on the arrow next to the button Want to read")
    public void clickOnTheArrowButton() {
        bookTitle = bookPage.getTitleBook();
        bookPage.clickOnTheArrowButton();
    }

    @When("I select the Currently reading field")
    public void selectingAField() {
        bookPage.clickCurrentlyButton();
    }

    @Then("A message appeared about adding a book to the list")
    public void checkingForAddingABook() {
        assertThat(bookPage.getTextFromMessage(), equalTo(messageAboutAddingBook));
    }

    @When("I click on Currently Reading link")
    public void clickCurrentlyReadingLink() {
        myBooksPage.clickCurrentlyReadingLink();
    }
    @Then("I closed browser")
    public void closeBrowser(){
        myBooksPage.quit();

    }


}
