import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainTitlePage extends WebDriverParent {
    private WebElement text;


    public MainTitlePage(WebDriver driver) {
        this.driver = driver;
        this.text = driver.findElement(By.xpath("//a[@href='/recommendations']"));
    }

    public String atMainPage() {
        return driver.getTitle();
    }

    public String getText() {
        return text.getText();
    }

    public void quit() {
        driver.quit();
    }

}