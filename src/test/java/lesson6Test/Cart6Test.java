package lesson6Test;

import lesson6.CartPage;
import lesson6.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static lesson5Test.AbstractTest.getDriver;

public class Cart6Test extends Abstract6Test{


    @Test
    void putInCart (){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.searchAndPutCart("маалокс");
        mainPage.goToCart();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://budzdorov.ru/checkout/cart"));
       Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//div[@class='cart__cart-btns']")), "в корзину не сохранился товар");

    }

    @Test
    void deleteFromCart(){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.searchAndPutCart("маалокс");
        mainPage.goToCart();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://budzdorov.ru/checkout/cart"));

        CartPage cartPage = new CartPage(getWebDriver());
        cartPage.putClearCart();

        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//p[@class ='mini-basket__empty-cart']")), "в корзине остался товар");
    }


}
