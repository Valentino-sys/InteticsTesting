import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BookPage extends WebDriverParent {
    private By buttonWantToRead = By.xpath("//button[@class='wtrToRead']");
    private By myBooksButton = By.xpath("//a[contains(text(),'My Books')]");
    private By msg = By.xpath("//div[@class='wtrPrompt wtrReorderShelf']");
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


    public void clickMyBooksButton() {
        driver.findElement(myBooksButton).click();
    }


}
