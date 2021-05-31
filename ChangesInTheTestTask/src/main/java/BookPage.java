import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookPage extends WebDriverParent {
    private By buttonWantToRead = By.xpath("//button[@class='wtrToRead']");
    private By myBooksButton = By.xpath("//a[contains(text(),'My Books')]");
    private By msg = By.xpath("//div[@class='wtrPrompt wtrReorderShelf']");
    private By arrow = By.xpath("//button[@class='wtrShelfButton']");
    private By fields = By.xpath("//div[@class='bookCoverActions']");
    private By messageAboutAddingABook = By.xpath("//span[@title='Currently Reading']");
    private By bookTitle = By.xpath("//h1[@id='bookTitle']");
    private By currentlyReadingButton = By.xpath("//span[contains(text(),'Currently Reading')]");
    private int waitingSize;
    private WebDriverWait wait;

    public BookPage(WebDriver driver) {
        this.driver = driver;
        this.waitingSize = 5;
        this.wait = new WebDriverWait(driver, 5);
    }

    public void settings() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(waitingSize, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(waitingSize, TimeUnit.SECONDS);
    }

    public void openBooksPage(String url) {
        driver.get(url);
    }

    public void clickButtonWantToRead() {
        driver.findElement(buttonWantToRead).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(msg));
    }

    public void clickOnTheArrowButton() {
        driver.findElement(arrow).click();
    }

    public void clickCurrentlyButton() {
        driver.findElement(currentlyReadingButton).click();
    }

    public String getTextFromMessage() {
        return driver.findElement(messageAboutAddingABook).getText();
    }

    public String getTitleBook() {
        return driver.findElement(bookTitle).getText();
    }

    public void clickMyBooksButton() {
        driver.findElement(myBooksButton).click();
    }


}
