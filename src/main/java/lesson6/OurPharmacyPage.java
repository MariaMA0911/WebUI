package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OurPharmacyPage extends AbstractPage{
    public OurPharmacyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath=".//input[@class='input pharmacies-grid-toolbar__search pharmacies-grid-toolbar__search_overlayed']")
    private WebElement searchLineCity;

    @FindBy(xpath = ".//a[@href='/store/view/50102']")
    private WebElement pharmacy1;

    public void inputCity(String value){
        searchLineCity.sendKeys(value);

    }

    public void choicePharmacy(){pharmacy1.click();}

}
