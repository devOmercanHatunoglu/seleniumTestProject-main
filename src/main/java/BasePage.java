import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class BasePage {

    WebDriver webDriver;


    public BasePage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public WebElement find(By locator) {

        return webDriver.findElement(locator);

    }

    public List<WebElement> findAll(By locator) {

        return webDriver.findElements(locator);
    }

    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void hoverPage2Element() {
        webDriver.get("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
    }

    public void waitForLoad() {
        By followTitleLocator = new By.ById("FollowTitle");
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(followTitleLocator));
    }

    public void typeText(By locator, String text) {

        find(locator).sendKeys(text);
    }

    public void selectDropDown(WebElement webElement, String value) {
        Select select = new Select(webElement);
        select.selectByValue(value);

    }

    public void randomSelect() {

        List<WebElement> allProducts = webDriver.findElements(By.cssSelector("div[class='sc-1favwb2-0 bTbNwr']>ul>li"));
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();

    }


}


