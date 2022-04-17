package lesson5Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class FiltrInCatalogBrendTest extends AbstractTest {
    @Test
    void FiltrsInCatalogBrend() {
        WebElement webElement1 = getDriver().findElement(By.xpath(".//span[@class='header-catalog-button__title']"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.xpath(".//a[@href='/category/2037']"));
        webElement2.click();
       //JavascriptExecutor js = (JavascriptExecutor) getDriver();
      // js.executeScript("window.scrollBy(0,200)");
        WebElement webElement3 = getDriver().findElement(By.xpath(".//input[@name='123647']"));
        webElement3.click();
        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//div[@class='filters__selecteds-item-label']")), "не сработал фильтр по бренду");

      // Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://budzdorov.ru/category/2037?filter=brendy_rig__123647"));

    }
}
