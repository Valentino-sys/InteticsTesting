import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends WebDriverParent {
    private WebElement loginButton;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signInButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.loginButton = driver.findElement(By.xpath("//a[@href='/user/sign_in']"));
        this.emailField = driver.findElement(By.xpath("//input[@id ='user_email']"));
        this.passwordField = driver.findElement(By.xpath("//input[@id='user_password']"));
        this.signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));

    }

    public void openLoginPage() {
        driver.get("https://www.goodreads.com/");
    }

    public void clickButton() {
        loginButton.click();
    }

    public void enterEmail(String eMail) {
        emailField.sendKeys(eMail);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickButtonSignIn() {
        signInButton.click();
    }

}