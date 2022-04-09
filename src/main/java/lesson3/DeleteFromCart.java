package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DeleteFromCart {

//Удаление товара из корзины
    //Шаги:
//1. Выбрать в корзину не менее 2-х наименований товара
//2. Нажать значок корзины
//3. Нажать "удаление" у каждого товара

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
       options.addArguments("start-maximized");
      options.addArguments("--incognito");
       options.addArguments("disable-popup-blocking");
        WebDriver driver = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://budzdorov.ru");

        WebElement webElement1 = driver.findElement(By.xpath(".//input[@class='input input_primary header__search-input']"));
        webElement1.sendKeys("маалокс");
        WebElement webElement2 = driver.findElement(By.xpath(".//div[@class='header__search-input-icon']"));
        webElement2.click();
        WebElement webElement3 = driver.findElement(By.xpath("(.//button[@class='button button_primary product__cart-btn'])[1]"));
        webElement3.click();
        WebElement webElement30 = driver.findElement(By.xpath("(.//button[@class='button button_primary product__cart-btn'])[2]"));
        webElement30.click();
        WebElement webElement4 = driver.findElement(By.xpath(".//a[@href='/checkout/cart/'][1]"));
        webElement4.click();
        WebElement webElement5 = driver.findElement(By.xpath("(.//button[@class='button mini-basket__remove-item-btn'])[1]"));
        webElement5.click();
        WebElement webElement6 = driver.findElement(By.xpath("(.//button[@class='button mini-basket__remove-item-btn'])[2]"));
        webElement6.click();

        driver.quit();
    }
}
