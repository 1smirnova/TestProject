package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.elements.HeaderElement;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.DOWN;
import static org.openqa.selenium.Keys.RETURN;

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
        Assert.assertTrue("Invalid page title - not Home Page"
                , isElementDisplayed(buttonLogin));
        return this;
    }

    public LoginPage clickOnButtonSignIn() {
        clickOnElement(buttonLogin);
        return new LoginPage(webDriver);
    }

    public HeaderElement getHeader() {
        return new HeaderElement(webDriver);
    }

    public HomePage enterFrom(String from) {
        enterTextIntoInput(inputFrom, from);
        return this;
    }

    public HomePage enterTo(String to) {
        enterTextIntoInput(inputTo, to);
        return this;
    }

    public HomePage enterDate(String date) {
        enterTextIntoInput(inputDate, date);
        return this;
    }

    public HomePage clickOnButtonSearch() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(buttonSearch).click().perform();
        clickOnElement(buttonSearch);
        return this;
    }
}
