import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BookPage extends WebDriverParent {
    private WebElement buttonWantToRead;
    private WebElement myBooksButton;
    private int waitingSize;

    public BookPage(WebDriver driver) {
        this.driver = driver;
        this.waitingSize = 5;
        this.buttonWantToRead = driver.findElement(By.xpath("//button[@class='wtrToRead']"));
        this.myBooksButton = driver.findElement(By.xpath("//a[contains(text(),'My Books')]"));
    }

    public void settings() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(waitingSize, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(waitingSize, TimeUnit.SECONDS);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void openBooksPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(waitingSize, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(waitingSize, TimeUnit.SECONDS);
    }

    public void clickButtonWantToRead() {
        buttonWantToRead.click();
    }


    public void clickMyBooksButton() {
        myBooksButton.click();
    }


}
