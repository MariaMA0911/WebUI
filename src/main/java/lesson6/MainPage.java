package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//div[@class='header__button header__button_account'][1]")
    private WebElement accountPage;

    @FindBy(xpath = ".//input[@class='input input_primary header__search-input']")
    private WebElement searchLine;

    @FindBy(xpath = ".//div[@class='header__search-input-icon']")
    private WebElement searchIcon;

    @FindBy(xpath = "(.//button[@class='button button_primary product__cart-btn'])[1]")
    private WebElement buttonBuy;

    @FindBy(xpath = ".//div[@class='header__button header__button_cart'][1]")
    private WebElement cartIcon;

    @FindBy(xpath = ".//a[@class='button button_primary mini-basket__to-cart-btn mini-basket__to-cart-btn_mobile-landscape']")
    private WebElement cartIn;

    @FindBy(xpath = ".//span[@class='header-catalog-button__title']")
    private WebElement catalog;

    @FindBy(xpath=".//a[@href='/category/2037']")
    private WebElement vitamins;

    @FindBy(xpath = ".//a[@class='link link_primary header-link header-link_pharmacies']")
    private WebElement ourPharmacy;

    public void goToAccountPage() {
        accountPage.click();
    }


    public void searchAndPutCart(String value){
        searchLine.sendKeys(value);
        searchIcon.click();
        buttonBuy.click();
    }

    public void goToCart(){
        cartIcon.click();
        cartIn.click();
        WebElement webElement =getDriver().findElement(By.xpath(".//button[@class='header__close-btn']"));
        webElement.click();

    }

    public void goToCatalog(){catalog.click();}

    public void goToVitamins(){vitamins.click();}

    public void goToOurPharmacy(){ourPharmacy.click();}
}
