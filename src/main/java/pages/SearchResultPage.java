package pages;

import org.openqa.selenium.WebDriver;

public class SearchResultPage extends ParentPage{
    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/rozklad-pkp/[a-zA-Z0-9]*";
    }

    public SearchResultPage checkIsRedirectToSearchResultPage() {
        checkUrlWithPattern();
        return this;
    }
}
