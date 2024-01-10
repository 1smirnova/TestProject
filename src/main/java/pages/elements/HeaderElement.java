package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;


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
}
