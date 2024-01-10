package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @Override
    protected String getRelativeUrl() {
        return "/signin";
    }

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
    public LoginPage checkIsRedirectToLoginPage() {
        checkUrl();
        Assert.assertTrue("Invalid page title - not Login Page"
                , isElementDisplayed(buttonSignIn));
        return this;
    }

    public MyPanelPage fillLoginFormAndSubmit(String email, String password) {
        checkIsElementVisible(inputEmail);
        enterTextIntoInput(inputEmail, email);
        checkIsElementVisible(inputPassword);
        enterTextIntoInput(inputPassword, password);
        checkIsElementVisible(buttonSignIn);
        clickOnElement(buttonSignIn);
        return new MyPanelPage(webDriver);
    }

    public LoginPage checkIsInputPasswordNotPresent() {
        checkElementIsNotVisible(inputPassword);
        return this;
    }

    public LoginPage checkIsInputUsernameNotPresent() {
        checkElementIsNotVisible(inputEmail);
        return this;
    }
}
