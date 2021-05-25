import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookPage {
    private WebDriver driver;

    public BookPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openBooksPage(String url) {
        driver.get(url);
    }

    public void clickButtonWantToRead() {
        driver.findElement(By.xpath("//button[@class='wtrToRead']")).click();
    }


    public void clickMyBooksButton(){
        driver.findElement(By.xpath("//a[contains(text(),'My Books')]")).click();
    }


}
