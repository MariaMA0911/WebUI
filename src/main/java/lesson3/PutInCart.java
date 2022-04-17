package lesson3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PutInCart {

    //Добавление товара в корзину
    //Шаги:
    //1. В строку поиска набрать: маалокс, нажать enter
    //2. Выбрать товар, нажать кнопку "В корзину"
    public static void main(String[] args) {
//устанавливаем драйвер
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //опция - открывать в максимальном окне экрана
      options.addArguments("start-maximized");
      //открывать в режиме инкогнито
      options.addArguments("--incognito");
      //блокировка всплывающих окон
      options.addArguments("disable-popup-blocking");
//создаем экземпляр вебдрайвера и подключаем опции
        WebDriver driver = new ChromeDriver(options);
        //указываем неявные ожидания, применяются ко всему проекту, должны быть всегда, 3 - неформальный стандарт
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //переходим на нужную страницу
        driver.get("https://budzdorov.ru");
        WebElement webElement01 = driver.findElement(By.xpath(".//button[@class='popup-metadata-type-slider-icon-btn']"));
        webElement01.click();
       WebElement webElement1 = driver.findElement(By.xpath(".//input[@class='input input_primary header__search-input']"));
      webElement1.sendKeys("маалокс");
        WebElement webElement2 = driver.findElement(By.xpath(".//div[@class='header__search-input-icon']"));
        webElement2.click();
        WebElement webElement3 = driver.findElement(By.xpath("(.//button[@class='button button_primary product__cart-btn'])[1]"));
        webElement3.click();
        WebElement webElement4 = driver.findElement(By.xpath("(.//a[@href='/checkout/cart/'])[1]"));
        webElement4.click();
        //ЗАВЕРШАЕМ РАБОТУ С РЕСУРСОМ
        driver.quit();
    }


}





