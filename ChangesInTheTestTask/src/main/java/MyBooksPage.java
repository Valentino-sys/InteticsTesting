import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyBooksPage extends WebDriverParent {
    private WebElement deleteButton;
    private WebElement msg;


    public MyBooksPage(WebDriver driver) {
        this.driver = driver;
        this.deleteButton = driver.findElement(By.xpath("//img [@alt = 'Remove from my books']"));
        this.msg = driver.findElement(By.xpath("//div[contains(text(),' No matching items!')]"));
    }

    public String booksListIsNotEmpty() {
        return driver.findElement(By.xpath("//div[@id='rightCol']")).getText();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public String booksListIsEmpty() {
        return msg.getText();
    }
    public  void  refresh(){
        driver.navigate().refresh();
    }
    public void quit(){
        driver.quit();
    }
}
