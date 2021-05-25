import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBooksPage {
    private WebDriver driver;

    public MyBooksPage(WebDriver driver) {
        this.driver = driver;
    }

    public String booksListIsNotEmpty() {
        return driver.findElement(By.xpath("//div[@id='rightCol']")).getText();
    }

    public void clickDeleteButton() {
        driver.findElement(By.xpath("//img [@alt = 'Remove from my books']")).click();
    }

    public String booksListIsEmpty() {
        return driver.findElement(By.xpath("//div[contains(text(),' No matching items!')]")).getText();
    }
    public  void  refresh(){
        driver.navigate().refresh();
    }
}
