package lesson5Test;

import org.example.AppTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PutInCartTest extends AbstractTest{
    static Logger logger = LoggerFactory.getLogger(PutInCartTest.class);
    //Добавление товара в корзину
    //Шаги:
    //1. В строку поиска набрать: маалокс, нажать enter
    //2. Выбрать товар, нажать кнопку "В корзину"
   // static Logger logger = LoggerFactory.getLogger(AppTest.class);
    @Test
    void PutInCartTest() {
        logger.error("ошибка");
       // logger.error("ошибка");
      //  getDriver().get("https://budzdorov.ru");
      //  WebElement webElement01 = getDriver().findElement(By.xpath(".//button[@class='popup-metadata-type-slider-icon-btn']"));
       // webElement01.click();
        WebElement webElement1 = getDriver().findElement(By.xpath(".//input[@class='input input_primary header__search-input']"));
        webElement1.sendKeys("маалокс");
        WebElement webElement2 = getDriver().findElement(By.xpath(".//div[@class='header__search-input-icon']"));
        webElement2.click();
        WebElement webElement3 = getDriver().findElement(By.xpath("(.//button[@class='button button_primary product__cart-btn'])[1]"));
        webElement3.click();
        WebElement webElement4 = getDriver().findElement(By.xpath("(.//a[@href='/checkout/cart/'])[1]"));
        webElement4.click();
        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//p[@class ='mini-basket__total']")), "в корзину не сохранился товар");
    }
}
