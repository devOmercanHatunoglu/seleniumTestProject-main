import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class BusinessTestClass extends BaseTestClass {


    HomePage homePage;
    ProductPage productPage;
    DetailPage detailPage;
    CartPage cartPage;
    String unitPrice;
    String confirmUnitPrice;
    Log log = new Log();

    @Test
    @Order(1)
    public void tryLogin() {

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("Test123@gmail.com", "Test123");
        log.info("Login İşlemi Başarılı.");
        Assertions.assertEquals("https://www.gittigidiyor.com/uye-girisi",webDriver.getCurrentUrl());




    }

    @Test
    @Order(2)
    public void searchProduct()  {
        homePage = new HomePage(webDriver);
        homePage.searchBox().search("Bilgisayar");

    }

    @Test
    @Order(3)
    public void goToPage2()  {
        homePage.goPage2();
        log.info("2.Sayfadasınız.");

    }

    @Test
    @Order(4)
    public void randomSelectProduct()  {
        productPage = new ProductPage(webDriver);
        productPage.randomSelectProduct();
        log.info("Rastgele Bir Ürün Seçildi.");
    }

    @Test
    @Order(5)
    public void addProductToCart() {
        detailPage = new DetailPage(webDriver);
        unitPrice = detailPage.getUnitPrice();
        detailPage.addToCart();
        log.info("Ürün Sepete Eklendi.");
    }

    @Test
    @Order(6)
    public void goToCart()  {
        detailPage.goToCart();
        Assertions.assertEquals("https://www.gittigidiyor.com/sepetim",webDriver.getCurrentUrl());
        log.info("Sepete Gidiliyor.");
    }

    @Test
    @Order(7)
    public void controlPrice()  {
        cartPage = new CartPage(webDriver);
        confirmUnitPrice = cartPage.confirmUnitPrice();
        Assertions.assertTrue(unitPrice.equals(confirmUnitPrice), "Fiyatlar Eşleşmiyor.");
        log.info("Fiyatlar Eşleşiyor.");

    }


    @Test
    @Order(8)
    public void controlIncreasedProduct()  {
        cartPage.increaseProduct();
        log.info("Ürün Adedi Arttırıldı.");
    }

    @Test
    @Order(9)
    public void deleteProductOnCart()  {
        cartPage.deleteProduct();
        log.info("Ürün Sepetten Silindi.");

    }


    @Test
    @Order(10)
    public void controlProductOnCart() throws InterruptedException {
        cartPage.controlCart();
        log.info("Sepet Boşaltıldı.");


    }
}







