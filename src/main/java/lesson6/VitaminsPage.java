package lesson6;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VitaminsPage extends AbstractPage{
    public VitaminsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath=".//input[@name='123647']")
    private WebElement brand;

    public void choiceBrand(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
         js.executeScript("window.scrollBy(0,400)");
        brand.click();}
}
