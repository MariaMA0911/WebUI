package lesson5Test;

import org.example.AppTest;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntranceRegisteredUserTest extends AbstractTest{
    static Logger logger = LoggerFactory.getLogger(EntranceRegisteredUserTest.class);
    //Вход зарегистрированного пользователя
    //Шаги
//1. Нажать значок "Вход/регистрация"
//2. Ввести валидные логин и пароль

    @Test
    void EntranceRegisteredUser()  {
        logger.error("ошибка");
        getDriver().navigate().to("https://budzdorov.ru/customer/account/login");
        Actions registration = new Actions(getDriver());
        registration.sendKeys(getDriver().findElement(By.name("userLogin")),"22fortest22@mail.ru")
                .sendKeys(getDriver().findElement(By.name("userPassword")),"123456789Ab")
                .click(getDriver().findElement(By.xpath(".//button[@type='submit']")))
                .build()
                .perform();

        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://budzdorov.ru/customer/account"));


    }
}
