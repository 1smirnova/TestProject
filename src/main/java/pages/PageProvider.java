package pages;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    private WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }

    public HomePage getHomePage() {
        return new HomePage(webDriver);
    }

    public MyPanelPage getMyPanelPage() {
        return new MyPanelPage(webDriver);
    }

    public MyAccountPage getMyAccountPage() {
        return new MyAccountPage(webDriver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(webDriver);
    }

    public TravelOptionsPage getTravelOptionsPage() {
        return new TravelOptionsPage(webDriver);
    }

}
