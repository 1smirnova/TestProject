package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends ParentPage {
    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/rozklad-pkp/.*";
    }

    @FindBy(xpath = "//*[@id=\"ember1457\"]/div[3]/div/div/div[1]/div[2]/span/span")
    private WebElement searchResultFrom;
    @FindBy(xpath = "//*[@id=\"ember1457\"]/div[3]/div/div/div[2]/div[2]/span")
    private WebElement searchResultTo;
    @FindBy(xpath = "//*[@class=\"koleoicon-warning right-padded-koleoicon\"]")
    private WebElement alertWithText;
    @FindBy(xpath = "//*[contains(@class, 'fastest')]")
    private WebElement resultFastest;
    @FindBy(xpath = "//*[@class='row station']")
    private WebElement resultStation;
    @FindBy(xpath = "//*[contains(@class, 'cheap-icon-text')]")
    private WebElement resultBuyTicket;
    @FindBy(xpath = "//*[@class='passenger-info']")
    private WebElement resultPassengerInfo;

    private String titleText = "//a[contains(text(),'%s')]";
    @FindBy(xpath = "//*[contains(@title, 'Kontynuuj kupowanie biletu')]")
    private WebElement buttonConfirmOrder;


    public SearchResultPage checkIsRedirectToSearchResultPage() {
        webDriverWait15.until(
                webDriver -> webDriver.getCurrentUrl().matches(baseUrl + getRelativeUrl())
        );
        checkUrlWithPattern();
        return this;
    }

    public SearchResultPage checkAlertWithTextIsPresent(String text) {
        checkTextInElement(alertWithText, text);
        logger.info("Alert with text " + text + " is present");
        return this;
    }

    public SearchResultPage checkTextInTitle(String text) {
        checkIsElementVisible(webDriver.findElement(By.xpath(String.format(titleText, text))));
        return this;
    }

    public SearchResultPage clickOnFastestResult() {
        clickOnElement(resultFastest);
        return this;
    }

    public SearchResultPage clickOnBuyTicket() {
        webDriverWait30.until(ExpectedConditions.visibilityOf(resultBuyTicket));
        clickOnElement(resultBuyTicket);
        return this;
    }
    public SearchResultPage checkPassengerInfoIsDisplayed() {
        webDriverWait30.until(ExpectedConditions.visibilityOf(resultPassengerInfo));
        checkIsElementVisible(resultPassengerInfo);
        return this;
    }
    public SearchResultPage clickOnButtonConfirmOrder() {
        webDriverWait30.until(ExpectedConditions.visibilityOf(buttonConfirmOrder));
        checkIsElementVisible(buttonConfirmOrder);
        clickOnElement(buttonConfirmOrder);
        return this;
    }

}
