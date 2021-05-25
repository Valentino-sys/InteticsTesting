import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SaveAndDeleteBook {
    private WebDriver driver;
    private BookPage bookPage;
    private MyBooksPage myBooksPage;
    private String messageText;

    public SaveAndDeleteBook() {
        this.driver = new FirefoxDriver();
        this.bookPage = new BookPage(driver);
        this.myBooksPage = new MyBooksPage(driver);
        this.messageText = "View shelf ";
    }

    @Given("I go to the book page 'url' $id")
    public void openBooksPage(@Named("id")String id) {
        bookPage.openBooksPage("https://www.goodreads.com/book/show/" + id);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @When("I click  button want to read")
    public void clickButton() {
        bookPage.clickButtonWantToRead();
    }

    @Then("The inscription View shelf appeared")
    public void bookSaveTest() {
        assertThat(bookPage.getTextFromMessage(), anyOf(containsString("View shelf")));
    }

    @Given("I go to the my books page")
    public void clickMyBooksButton() {
        bookPage.clickMyBooksButton();
    }

    @When("I check that my book is on the list")
    public void checkListBooksTest() {
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

}
