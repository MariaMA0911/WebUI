package lesson5Test;


import org.example.AppTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteFromCartTest extends AbstractTest{
    static Logger logger = LoggerFactory.getLogger(DeleteFromCartTest.class);

//Удаление товара из корзины
    //Шаги:
//1. Выбрать в корзину товар
//2. Нажать значок корзины
//3. Нажать "удаление" у товара

    @Test
    void DeleteFromCart (){
        logger.error("ошибка");
       WebElement webElement1 = getDriver().findElement(By.xpath(".//input[@class='input input_primary header__search-input']"));
       webElement1.sendKeys("маалокс");
        WebElement webElement2 = getDriver().findElement(By.xpath(".//div[@class='header__search-input-icon']"));
        webElement2.click();
        WebElement webElement3 = getDriver().findElement(By.xpath("(.//button[@class='button button_primary product__cart-btn'])[1]"));
        webElement3.click();

        WebElement webElement4 = getDriver().findElement(By.xpath(".//a[@href='/checkout/cart/'][1]"));
        webElement4.click();
        WebElement webElement5 = getDriver().findElement(By.xpath("(.//button[@class='button mini-basket__remove-item-btn'])"));
        webElement5.click();
        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//p[@class ='mini-basket__empty-cart']")), "в корзине остался товар");

    }

}
