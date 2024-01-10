package pages;

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

    public MyPanelPage(WebDriver webDriver) {
        super(webDriver);
    }
}
