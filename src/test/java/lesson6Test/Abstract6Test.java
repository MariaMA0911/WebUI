package lesson6Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.MyWebDriverEventListener;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Abstract6Test {
    //static WebDriver webDriver;
    static EventFiringWebDriver eventDriver;
    @BeforeAll
    static void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        //webDriver = new ChromeDriver(options);
        eventDriver = new EventFiringWebDriver(new ChromeDriver(options));
        eventDriver.register(new MyWebDriverEventListener());
        eventDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @BeforeEach
    void initMainPage(){
        Assertions.assertDoesNotThrow( ()-> getWebDriver().navigate().to("https://budzdorov.ru"),
                "Страница не доступна");
        Assertions.assertTrue(true);
       // WebElement webElement2 = getWebDriver().findElement(By.xpath(".//button[@class='popup-metadata-type-slider-icon-btn']"));
       // webElement2.click();

    }
    //логи браузера
    @AfterEach
    public void checkBrowser(){
        List<LogEntry> allLogRows = getWebDriver().manage().logs().get(LogType.BROWSER).getAll();
        if(!allLogRows.isEmpty()){

            if (allLogRows.size() > 0 ) {
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });

            }

        }

    }

    @AfterAll
    public static void exit(){

        if(eventDriver !=null) eventDriver.quit();
    }

    public WebDriver getWebDriver(){
        return this.eventDriver;
    }
}
