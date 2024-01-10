package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends ParentPage {

    @Override
    protected String getRelativeUrl() {
        return "/signup";
    }

    public SignUpPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//*[@id='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//*[@id='pass_confirmation']")
    private WebElement inputPasswordConfirmation;
    @FindBy(xpath = "//*[@id='ember1346']")
    private WebElement checkboxTerms;
    @FindBy(xpath = "//*[@id='ember1348']")
    private WebElement chechboxPrivacy;
    @FindBy(xpath = "//*[@id='signup']")
    private WebElement buttonSignUp;

}
