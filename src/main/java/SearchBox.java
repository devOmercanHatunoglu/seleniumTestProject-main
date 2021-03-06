import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage {

    By searchBoxLocator = new By.ByXPath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");
    By buttonOnClick = new By.ByXPath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[2]/button");

    public SearchBox(WebDriver webDriver) {
        super(webDriver);
    }

    public void search(String text) {
        typeText(searchBoxLocator, text);
        click(buttonOnClick);
    }


}
