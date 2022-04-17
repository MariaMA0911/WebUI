package lesson5Test;

import org.example.AppTest;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntranceRegisteredUserTest extends AbstractTest{
    //Вход зарегистрированного пользователя
    //Шаги
//1. Нажать значок "Вход/регистрация"
//2. Ввести валидные логин и пароль

    @Test
    void EntranceRegisteredUser()  {
        getDriver().navigate().to("https://budzdorov.ru/customer/account/login");
        WebElement webElement2 =  getDriver().findElement(By.name("userLogin"));
        webElement2.sendKeys("22fortest22@mail.ru");

        WebElement webElement3 =  getDriver().findElement(By.name("userPassword"));
        webElement3.sendKeys("123456789Ab");

        WebElement webElement4 =  getDriver().findElement(By.xpath(".//button[@type='submit']"));
        webElement4.click();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://budzdorov.ru/customer/account"));


    }
}
