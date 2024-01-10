package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends CommonActionsWithElements {
    final String baseUrl = "https://koleo.pl";
    abstract protected String getRelativeUrl();


    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected void checkUrl() {
        Assert.assertEquals("Invalid page URL",
                baseUrl + getRelativeUrl(),
                webDriver.getCurrentUrl()
        );
    }

}
