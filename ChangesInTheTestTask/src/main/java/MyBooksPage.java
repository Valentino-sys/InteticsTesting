import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyBooksPage extends WebDriverParent {
    private WebDriverWait wait;
    private int timeOutSecond;
    private By deleteButton = By.xpath("//img [@alt = 'Remove from my books']");
    private By msg = By.xpath("//div[contains(text(),' No matching items!')]");
    private By currentlyReadingLink = By.xpath("//a[@href='/review/list/134262262-valentin?ref=nav_mybooks&shelf=currently-reading']");
    private By titleBook = By.xpath("//div[@id='rightCol']");


    public MyBooksPage(WebDriver driver) {
        this.driver = driver;
        this.timeOutSecond = 5;
        this.wait = new WebDriverWait(driver, timeOutSecond);
    }

    public String booksListIsNotEmpty() {
        return driver.findElement(titleBook).getText();
    }

    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();
    }

    public void explicitWait() {
        wait.until(ExpectedConditions.presenceOfElementLocated(msg));
    }

    public String booksListIsEmpty() {
        return driver.findElement(msg).getText();
    }

    public void browserNotification() {
        driver.switchTo().alert().accept();
    }

    public void clickCurrentlyReadingLink() {
        driver.findElement(currentlyReadingLink).click();
    }

    public void quit() {
        driver.quit();
    }
}
