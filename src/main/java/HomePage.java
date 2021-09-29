import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    SearchBox searchBox;
    By closeCookies = new By.ByXPath("//span[text()='Kapat']");


    public HomePage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("https://www.gittigidiyor.com/");
        searchBox = new SearchBox(webDriver);
    }

    public SearchBox searchBox() {

        return this.searchBox;
    }

    public void goPage2() {

        click(closeCookies);
        hoverPage2Element();

    }

    
}
