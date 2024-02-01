package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends ParentPage {
    @FindBy(xpath = "//*[@class='section-heading__title']")
    private WebElement myAccountTitle;
    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div[1]/div/div[2]/div[1]/div/form/div[2]/label/div/input")
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


    @Override
    protected String getRelativeUrl() {
        return "/my/account";
    }

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MyAccountPage checkIsRedirectToMyAccountPage() {
        checkUrl();
        checkIsElementVisible(myAccountTitle);
        return this;
    }

    public MyAccountPage addTextToInputFirstName(String changedName) {
        enterTextIntoInput(inputName, changedName);
        return this;
    }

    public MyAccountPage addTextToInputLastName(String changedLastName) {
        enterTextIntoInput(inputName, changedLastName);
        return this;
    }

    public MyAccountPage selectDayOfBirth(String number) {
        enterTextIntoInput(inputDayOfBirth, number);
        return this;
    }

    public MyAccountPage selectDiscount(String value) throws InterruptedException {
        clickOnElement(selectDiscount);
        enterTextIntoInput(selectDiscount, value);
        return this;
    }

    public MyAccountPage saveChanges() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(buttonSaveChanges).click().build().perform();
        return this;
    }

    public MyAccountPage refreshPage() {
        webDriver.navigate().refresh();
        return this;
    }
}
