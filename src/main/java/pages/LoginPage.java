package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//*[@id='pass']")
    private WebElement inputPassword;
    @FindBy(xpath = "//*[@id='signin']")
    private WebElement buttonSignIn;
    @FindBy(xpath = "//*[@id='new_user']/div[1]/div[2]")
    private WebElement invalidLoginAlert;

    private String invalidLoginAlertText = "Niepoprawny email lub hasło.";


}
