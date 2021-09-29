import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;


public class CartPage extends BasePage {

    By confirmUnitPriceLocator = new By.ByClassName("new-price");
    By dropDownLocator = new By.ByXPath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[1]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[4]/div/div[2]/select");
    By deleteProductLocator = new By.ByCssSelector("a[title='Sil']");
    By controlCartLocator = new By.ByCssSelector("#empty-cart-container > div.gg-w-15.gg-d-14.gg-t-14.gg-m-24 > div:nth-child(1) > div > div.gg-d-19.gg-w-21.gg-t-19.gg-m-18 > h2");

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }


    public String confirmUnitPrice() {

        return find(confirmUnitPriceLocator).getText().replace(" ", "");

    }

    public void increaseProduct() {

        selectDropDown(find(dropDownLocator), "2");
    }

    public void deleteProduct() {

        click(deleteProductLocator);


    }

    public void controlCart() throws InterruptedException {

        String check = webDriver.findElement(controlCartLocator).getText();
        String emptyString = "Sepetinizde ürün bulunmamaktadır." + "\n" +
                "Alışverişe devam etmek için anasayfaya gidebilir veya Günün Fırsatı ürünlerine göz atabilirsiniz.";
        System.out.println(check);
        if (Objects.equals(check, emptyString)) {
            System.out.println("Sepet Boş");
        }
        Thread.sleep(8000);

    }

}
