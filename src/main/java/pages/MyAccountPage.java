package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends ParentPage {
    @FindBy(xpath = "//*[@class='section-heading__title']")
    private WebElement myAccountTitle;
    @FindBy(xpath = "//*[@class='form-input__control']")
    private WebElement inputName;
    @FindBy(xpath = "//*[@placeholder='Dzień']")
    private WebElement inputDayOfBirth;
    @FindBy(xpath = "//*[@id='vs8__combobox']")
    private WebElement selectDiscount;
    @FindBy(xpath = "//*[@id='vs7__combobox']")
    private WebElement inputMonthOfBirth;
    @FindBy(xpath = "//*[@placeholder='Rok']")
    private WebElement inputYearOfBirth;
    @FindBy(xpath = "//button[@class='form-submit']")
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

    public MyAccountPage selectDiscount(String value) {
        selectValueInDropDown(selectDiscount, value);
        return this;
    }
}
