package lesson5Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.AppTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    static Logger logger = LoggerFactory.getLogger(AppTest.class);
    private static WebDriver driver;

    @BeforeAll
    static void init(){
        logger.error("ошибка");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://budzdorov.ru"),
                "Страница не доступна");
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement webElement01 = getDriver().findElement(By.xpath(".//button[@class='popup-metadata-type-slider-icon-btn']"));
        webElement01.click();
    }

    @AfterAll
    static void close(){

        driver.quit();
    }
    public static WebDriver getDriver() {
        return driver;
    }


}
