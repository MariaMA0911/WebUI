package lesson6Test;

import io.qameta.allure.*;
import lesson6.CartPage;
import lesson6.MainPage;
import lesson6.MyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static lesson5Test.AbstractTest.getDriver;

@Story("Тестирование корзины")
public class Cart6Test extends Abstract6Test{


    @Test
    @Description("Положить товар в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://budzdorov.ru")
    @TmsLink("https://github.com/MariaMA0911/WebUI/tree/master/src/test/java/lesson6Test")
    void putInCart (){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.searchAndPutCart("маалокс");
        mainPage.goToCart();
        MyUtils.makeScreenshot(getWebDriver(),
                "Сart6Test.putInCart" + System.currentTimeMillis() + ".png");
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://budzdorov.ru/checkout/cart"));
       Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//div[@class='cart__cart-btns']")), "в корзину не сохранился товар");

    }

    @Test
    @Description("Удалить товар из корзины")
    @Link("https://budzdorov.ru")
    @Severity(SeverityLevel.CRITICAL)
    void deleteFromCart(){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.searchAndPutCart("маалокс");
        mainPage.goToCart();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://budzdorov.ru/checkout/cart"));

        CartPage cartPage = new CartPage(getWebDriver());
        cartPage.putClearCart();
        MyUtils.makeScreenshot(getWebDriver(),
                "Сart6Test.deleteFromCart" + System.currentTimeMillis() + ".png");
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//p[@class ='mini-basket__empty-cart']")), "в корзине остался товар");
    }


}
