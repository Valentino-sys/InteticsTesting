import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
   private WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get("https://www.goodreads.com/");
    }

    public void enterEmail(String eMail) {
        driver.findElement(By.xpath("//input[@id='userSignInFormEmail']")).sendKeys(eMail);
    }

    public void enterPassword(String password) {
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(password);
    }

    public void clickButtonSignIn() {
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
    }

}
