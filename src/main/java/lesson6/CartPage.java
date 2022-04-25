package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

@FindBy(xpath=".//button[@class='button cart__clear-cart-btn']")
    private WebElement clearCart;

    public void putClearCart(){clearCart.click();}
}
