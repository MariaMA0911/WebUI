package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SearchPharmacy {
    //Поиск аптеки по городу
    //Шаги
// 1. Нажать вкладку "Наши аптеки"
//2. В строку поиска ввести название города
// 3. Нажать на адрес любой аптеки из списка

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://budzdorov.ru");

        driver.navigate().to("https://budzdorov.ru/store");

        WebElement webElement1 = driver.findElement(By.xpath(".//input[@class='input pharmacies-grid-toolbar__search pharmacies-grid-toolbar__search_overlayed']"));
        webElement1.sendKeys("Коломна");

        WebElement webElement2 = driver.findElement(By.xpath(".//a[@href='/store/view/50102']"));
        webElement2.click();

        driver.quit();

    }
}
