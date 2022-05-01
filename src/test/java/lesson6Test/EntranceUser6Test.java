package lesson6Test;

import io.qameta.allure.*;
import lesson6.LoginPage;
import lesson6.MainPage;
import lesson6.MyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Story("Вход пользователя")
public class EntranceUser6Test extends Abstract6Test{

    @Test
    @Description("Вход зарегистрированного пользователя")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://budzdorov.ru")
    @TmsLink("https://github.com/MariaMA0911/WebUI/tree/master/src/test/java/lesson6Test")
    void LoginInRegistratedUser(){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.goToAccountPage();
        //Assertions.assertEquals("https://budzdorov.ru/customer/account/login", getWebDriver().getCurrentUrl());

        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.LoginIn("22fortest22@mail.ru", "123456789Ab");
        MyUtils.makeScreenshot(getWebDriver(),
                "EntranceUser6Test.LoginInRegistratedUser" + System.currentTimeMillis() + ".png");
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://budzdorov.ru/customer/account"));
    }


    @Test
    @Description("Вход с неправильным логином")
    @Severity(SeverityLevel.MINOR)
    @Link("https://budzdorov.ru")
    @TmsLink("https://github.com/MariaMA0911/WebUI/tree/master/src/test/java/lesson6Test")
    void LoginInErrorLogin(){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.goToAccountPage();

        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.LoginIn("11111111", "123456789Ab");
        MyUtils.makeScreenshot(getWebDriver(),
                "EntranceUser6Test.LoginInErrorLogin" + System.currentTimeMillis() + ".png");
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//span[@class='text text_warning login-form__error']")), "не появилось сообщение об ошибке");

    }
}
