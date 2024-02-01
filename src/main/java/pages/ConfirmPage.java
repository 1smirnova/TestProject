package pages;

import org.openqa.selenium.WebDriver;
public class ConfirmPage extends ParentPage {
    public ConfirmPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/confirm/.*";
    }
}
