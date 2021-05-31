import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClassicBooksPage extends WebDriverParent {
    private By mainPageText = By.xpath("//h1[contains(text(),'Classics')]");
    private By listOfBooks = By.xpath("//div[@class='coverRow   ']");
    private List<WebElement> books;

    public ClassicBooksPage(WebDriver driver) {
        this.driver = driver;
    }

    public String atClassicBooksPage() {
        return driver.findElement(mainPageText).getText();
    }

    public void selectingBookFromTheList() {
        books = driver.findElements(listOfBooks);
        books.get(2).click();
    }

}
