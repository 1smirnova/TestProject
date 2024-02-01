package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends ParentPage {
    @FindBy(xpath = "//*[@class='section-heading__title']")
    private WebElement myAccountTitle;
    @FindBy(xpath = "//*[@type='text'][1]")
    private WebElement inputName;
    @FindBy(xpath = "//*[@placeholder='Dzień']")
    private WebElement inputDayOfBirth;
    @FindBy(xpath = "//*[@id='vs3__combobox']")
    private WebElement selectDiscount;
    @FindBy(xpath = "//*[@id='vs7__combobox']")
    private WebElement inputMonthOfBirth;
    @FindBy(xpath = "//*[@placeholder='Rok']")
    private WebElement inputYearOfBirth;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSaveChanges;
    @FindBy(xpath = "//p[contains(text(),'To pole nie może być puste.')]")
    private WebElement validationMessage;


    @Override
    protected String getRelativeUrl() {
        return "/my/account";
    }

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MyAccountPage checkIsRedirectToMyAccountPage() {
        webDriverWait15.until(
                webDriver -> webDriver.getCurrentUrl().matches(baseUrl + getRelativeUrl())
        );
        checkUrl();
        checkIsElementVisible(myAccountTitle);
        return this;
    }

    public MyAccountPage addTextToInputFirstName(String changedName) {
        enterTextIntoInput(inputName, changedName);
        return this;
    }

    public MyAccountPage saveChanges() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(buttonSaveChanges).click().build().perform();
        return this;
    }
}
