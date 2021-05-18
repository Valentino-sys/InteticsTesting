import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainTitlePage {
    private WebDriver driver;

    public MainTitlePage(WebDriver driver) {
        this.driver = driver;
    }

    public String atMainPage() {
        return driver.getTitle();
    }
    public String getText(){
        return driver.findElement(By.xpath("//a[@href='/recommendations']")).getText();
    }

    public void quit() {
        driver.quit();
    }

}