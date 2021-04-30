import org.openqa.selenium.WebDriver;

public class MainTitlePage {
    private WebDriver driver;

    public MainTitlePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean atMainPage() {
        boolean result = (("Recent updates | Goodreads").equals(driver.getTitle()) ? true : false);
        return result;
    }

    public void quit() {
        driver.quit();
    }
}
