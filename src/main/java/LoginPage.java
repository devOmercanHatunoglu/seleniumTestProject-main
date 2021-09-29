import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

    private WebDriver driver;
    By userNameField = By.id("L-UserNameField");
    By passwordField = By.id("L-PasswordField");
    By loginButton = By.id("gg-login-enter");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        this.driver.get("https://www.gittigidiyor.com/uye-girisi?s=1");
        driver.findElement(userNameField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        WebElement loginElement = driver.findElement(loginButton);
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(loginElement).build().perform();
        loginElement.click();

    }
}