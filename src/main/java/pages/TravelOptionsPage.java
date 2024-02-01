package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TravelOptionsPage extends ParentPage {

    public TravelOptionsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/travel-options/.*";
    }

    @FindBy(xpath = "//*[@class='small-16 columns']/h2")
    private WebElement travelOptionsTitle;
    @FindBy(xpath = "//*[@class='expand confirm_order']")
    private WebElement buttonConfirmOrder;
    @FindBy(xpath = "//*[@class='order-shipment__promo-title']")
    private WebElement promoTitle;

    public TravelOptionsPage checkIsRedirectToTravelOptionsPage() {
        webDriverWait30.until(
                webDriver -> webDriver.getCurrentUrl().matches(baseUrl + getRelativeUrl())
        );
        checkUrlWithPattern();
        return this;
    }

    public TravelOptionsPage checkTextInTravelOptionsTitle(String text) {
        webDriverWait30.until(
                webDriver -> webDriver.getCurrentUrl().matches(baseUrl + getRelativeUrl())
        );
        checkIsElementVisible(travelOptionsTitle);
        checkTextInElement(travelOptionsTitle, text);
        return this;
    }

    public TravelOptionsPage clickOnButtonConfirmOrder() {
        checkIsElementVisible(buttonConfirmOrder);
        clickOnElement(buttonConfirmOrder);
        return this;
    }

    public TravelOptionsPage checkPromoTitle(String text) {
        webDriverWait30.until(ExpectedConditions.visibilityOf(promoTitle));
        checkIsElementVisible(promoTitle);
        return this;
    }
}
