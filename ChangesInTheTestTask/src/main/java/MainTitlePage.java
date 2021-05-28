import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainTitlePage extends WebDriverParent {
    private By text = By.xpath("//a[@href='/recommendations']");


    public MainTitlePage(WebDriver driver) {
        this.driver = driver;
    }

    public String atMainPage() {
        return driver.getTitle();
    }

    public String getText() {
        return driver.findElement(text).getText();
    }

    public void quit() {
        driver.quit();
    }

}