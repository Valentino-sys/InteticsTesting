import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class MainTitlePage extends WebDriverParent {
    private By text = By.xpath("//a[@href='/recommendations']");
    private By browseButton = By.xpath("//span[contains(text(),'Browse ▾')]");
    private By classicsButton = By.xpath("//a[@href='/genres/classics']");


    public MainTitlePage(WebDriver driver) {
        this.driver = driver;
    }

    public String atMainPage() {
        return driver.getTitle();
    }

    public String getText() {
        return driver.findElement(text).getText();
    }

    public void clickButtonBrowse() {
        driver.findElement(browseButton).click();

    }

    public void clickButtonClassics() {
        driver.findElement(classicsButton).click();
    }


}