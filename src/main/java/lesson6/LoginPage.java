package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "userLogin")
    private WebElement login;

    @FindBy(name = "userPassword")
    private WebElement password;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement submit;

    public LoginPage setLogin(String login){
        this.login.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password){

        this.password.sendKeys(password);
        return this;
    }



    public void LoginIn (String login, String password){
        Actions loginIn = new Actions(getDriver());
        loginIn
                .sendKeys(this.login, login)
                .sendKeys(this.password, password)
                .click(this.submit)
                .build()
                .perform();
    }

}
