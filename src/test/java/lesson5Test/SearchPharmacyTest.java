package lesson5Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchPharmacyTest extends AbstractTest {
    static Logger logger = LoggerFactory.getLogger(SearchPharmacyTest.class);
    @Test
    void SearchPharmacy() {
        logger.error("ошибка");
        getDriver().navigate().to("https://budzdorov.ru/store");

        WebElement webElement1 = getDriver().findElement(By.xpath(".//input[@class='input pharmacies-grid-toolbar__search pharmacies-grid-toolbar__search_overlayed']"));
        webElement1.sendKeys("Коломна");

        WebElement webElement2 = getDriver().findElement(By.xpath(".//a[@href='/store/view/50102']"));
        webElement2.click();

        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://budzdorov.ru/store/view/50102"));
    }

}
