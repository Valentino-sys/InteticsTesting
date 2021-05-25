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

    public String getTextFromMessage() {
        return driver.findElement(By.xpath("//a[@href='/review/list/134262262?shelf=to-read']")).getText();
    }

    public void clickMyBooksButton(){
        driver.findElement(By.xpath("//a[@data-reactid='.16q11frkr70.1.0.2.0.1.0']")).click();
    }


}
