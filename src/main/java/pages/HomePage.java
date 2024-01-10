package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class HomePage extends ParentPage {
    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id='ember1035']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//*[@id='ember1036']")
    private WebElement buttonRegister;
    @FindBy(xpath = "//*[@placeholder='Z']")
    private WebElement inputFrom;
    @FindBy(xpath = "//*[@placeholder='DO']")
    private WebElement inputTo;
    @FindBy(xpath = "//*[@placeholder='KIEDY']")
    private WebElement inputDate;
    @FindBy(xpath = "//*[@id='small_search']")
    private WebElement buttonSearch;
    @FindBy(xpath = "//*[@class='   fastest ']")
    private WebElement resultFastest;
    @FindBy(xpath = "//*[@class='row station']")
    private WebElement resultStation;

    public HomePage openHomePage() {
        try {
            webDriver.get("https://koleo.pl/");
            logger.info("Home page was opened");
        } catch (Exception e) {
            logger.error("Can not open Home Page");
            Assert.fail("Can not open Home Page");
        }
        return this;
    }

    public HomePage checkIsRedirectToHomePage() {
        checkUrl();
        getHeader().checkIsButtonMyPanelVisible();
        return this;
    }

    public LoginPage clickOnButtonSignIn() {
        clickOnElement(buttonLogin);
        return new LoginPage(webDriver);
    }

    public HeaderElement getHeader() {
        return new HeaderElement(webDriver);
    }
}
