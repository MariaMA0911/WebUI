package lesson6Test;

import lesson6.LoginPage;
import lesson6.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntranceUser6Test extends Abstract6Test{

    @Test
    void LoginInRegistratedUser(){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.goToAccountPage();
        //Assertions.assertEquals("https://budzdorov.ru/customer/account/login", getWebDriver().getCurrentUrl());

        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.LoginIn("22fortest22@mail.ru", "123456789Ab");
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://budzdorov.ru/customer/account"));
    }


    @Test
    void LoginInErrorLogin(){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.goToAccountPage();

        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.LoginIn("11111111", "123456789Ab");
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//span[@class='text text_warning login-form__error']")), "не появилось сообщение об ошибке");

    }
}
