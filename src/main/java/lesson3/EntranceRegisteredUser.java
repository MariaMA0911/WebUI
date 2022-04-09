package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EntranceRegisteredUser {
    public static void main(String[] args) {


//Вход зарегистрированного пользователя
        //Шаги
//1. Нажать значок "Вход/регистрация"
//2. Ввести валидные логин и пароль

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://budzdorov.ru");
//переделать через навигацию
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains(""));
        driver.navigate().to("https://budzdorov.ru/customer/account/login");
        //WebElement webElement1 = driver.findElement(By.xpath("(//a[@href='/customer/account/'])[1]"));
        //webElement1.click();

        WebElement webElement2 = driver.findElement(By.name("userLogin"));
        webElement2.sendKeys("22fortest22@mail.ru");

       WebElement webElement3 = driver.findElement(By.name("userPassword"));
        webElement3.sendKeys("123456789Ab");

        WebElement webElement4 = driver.findElement(By.xpath(".//button[@type='submit']"));
        webElement4.click();

        driver.quit();

    }
}
