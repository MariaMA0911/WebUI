package lesson6Test;

import io.qameta.allure.*;
import lesson6.MainPage;
import lesson6.VitaminsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

@Story("Тестирование каталога")
public class Catalog6Test extends Abstract6Test{

    @Test
    @Description("Выбрать фильтр по бренду")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://budzdorov.ru")
    @TmsLink("https://github.com/MariaMA0911/WebUI/tree/master/src/test/java/lesson6Test")
    void filtrBrand(){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.goToCatalog();
        mainPage.goToVitamins();
        Assertions.assertEquals("https://budzdorov.ru/category/2037", getWebDriver().getCurrentUrl());

        VitaminsPage vitaminsPage = new VitaminsPage(getWebDriver());
        vitaminsPage.choiceBrand();
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath(".//div[@class='filters__selecteds-item-label']")), "не сработал фильтр по бренду");
    }
}
