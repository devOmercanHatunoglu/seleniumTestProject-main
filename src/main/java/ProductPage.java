import org.openqa.selenium.WebDriver;


public class ProductPage extends BasePage {

    BasePage basePage = new BasePage(webDriver);

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void randomSelectProduct() {

        randomSelect();


    }

}
