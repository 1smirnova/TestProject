package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyPanelPage extends ParentPage {
    @FindBy(xpath = "//*[@class='section-heading__title']")
    private WebElement myProfileTitle;
    @FindBy(xpath = "//*[@class='user-ribbon__name']")
    private WebElement userName;
    @FindBy(xpath = "//*[@class='user-ribbon__email']")
    private WebElement userEmail;
    @FindBy(xpath = "//*[@class='user-ribbon__discount']")
    private WebElement userDiscount;
    @FindBy(xpath = "//*[@href='/my/account']")
    private WebElement myAccountBtn;
    @FindBy(xpath = "//*[@id='signin']")
    private WebElement buttonSignIn;

    @Override
    protected String getRelativeUrl() {
        return "/my";
    }

    public MyPanelPage(WebDriver webDriver) {
        super(webDriver);
    }

    //check the redirect to the MyPanelPage
    public MyPanelPage checkIsRedirectToMyPanelPage() {
        checkUrl();
        Assert.assertTrue("Invalid page title - not My Panel Page"
                , isElementDisplayed(buttonSignIn));
        return this;
    }
    public MyAccountPage clickOnMyAccountButton() {
        clickOnElement(myAccountBtn);
        return new MyAccountPage(webDriver);
    }
}
