package lesson5Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EntranceRegisteredUserErrorLoginTest extends AbstractTest {
    //попытка входа при некорректном логине
    @Test
    void EntranceRegisteredUserErrorLogin() {
        getDriver().navigate().to("https://budzdorov.ru/customer/account/login");
        Actions registration = new Actions(getDriver());
        registration.sendKeys(getDriver().findElement(By.name("userLogin")),"11111111")
                .sendKeys(getDriver().findElement(By.name("userPassword")),"123456789Ab")
                .click(getDriver().findElement(By.xpath(".//button[@type='submit']")))
                .build()
                .perform();

        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//span[@class='text text_warning login-form__error']")), "не появилось сообщение об ошибке");

    }
}
