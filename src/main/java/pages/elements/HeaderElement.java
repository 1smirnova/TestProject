package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CommonActionsWithElements;
import pages.MyAccountPage;


public class HeaderElement extends CommonActionsWithElements {
    @FindBy(xpath = "//*[@href='/my/orders']")
    private WebElement myOrdersBtn;
    @FindBy(xpath = "//*[@href='/my']")
    private WebElement myProfileBtn;


    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderElement checkIsButtonMyPanelVisible() {
        checkIsElementVisible(myProfileBtn);
        return this;
    }

    public HeaderElement checkIsButtonMyOrdersVisible() {
        checkIsElementVisible(myOrdersBtn);
        return this;
    }
    public HeaderElement checkTextInMyOrdersBtn(String text) {
        webDriverWait30.until(ExpectedConditions.textToBePresentInElement(myOrdersBtn, text));
        checkTextInElement(myOrdersBtn, text);
        return this;
    }
    public HeaderElement checkIsButtonMyPanelNotVisible() {
        checkElementIsNotVisible(myProfileBtn);
        return this;
    }

    public HeaderElement checkIsButtonMyOrdersNotVisible() {
        checkElementIsNotVisible(myOrdersBtn);
        return this;
    }

    public HeaderElement clickOnMyPanelButton() {
        webDriverWait15.until(ExpectedConditions.elementToBeClickable(myProfileBtn));
        clickOnElement(myProfileBtn);
        return this;
    }
}
