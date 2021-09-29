import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailPage extends BasePage {

    By addToCartButtonLocator = new By.ById("add-to-basket");
    By closeCookies = new By.ByXPath("//span[text()='Kapat']");
    By cartContainerLocator = new By.ByXPath("/html/body/div[1]/div[2]/div/div[4]/div[3]/div/div/div/div[2]/div[4]/div[1]/a");
    By unitPriceLocator = new By.ById("sp-price-lowPrice");

    public DetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void goToCart() {
        click(cartContainerLocator);
    }

    public void addToCart() {
        waitForLoad();
        click(closeCookies);
        click(addToCartButtonLocator);

    }

    public String getUnitPrice() {

        return find(unitPriceLocator).getText().replace(" ", "");

    }


}
