import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends WebDriverParent {
    private By loginButton = By.xpath("//a[@href='/user/sign_in']");
    private By emailField = By.xpath("//input[@id ='user_email']");
    private By passwordField = By.xpath("//input[@id='user_password']");
    private By signInButton = By.xpath("//input[@value='Sign in']");
    private UrlLink url;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.url = UrlLink.URL_LOGIN_PAGE;
    }

    public void openLoginPage() {
        driver.get(url.getUrlAddress());

    }

    public void clickButton() {
        driver.findElement(loginButton).click();
    }

    public void enterEmail(String eMail) {
        driver.findElement(emailField).sendKeys(eMail);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickButtonSignIn() {
        driver.findElement(signInButton).click();
    }

}