package searchTests;

import baseTest.BaseTest;
import org.junit.Test;

import static libs.TestData.VALID_LOGIN_UI;
import static libs.TestData.VALID_PASSWORD_UI;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest() throws InterruptedException {
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .clickOnButtonSignIn()
                .checkIsRedirectToLoginPage()
                .fillLoginFormAndSubmit(VALID_LOGIN_UI, VALID_PASSWORD_UI);
        pageProvider.getHomePage().enterFrom("Warszawa Zachodnia")
                .enterTo("Warszawa Centralna")
                .enterDate("12-02-2024")
                .clickOnButtonSearch()
                .clickOnButtonSearch();
        Thread.sleep(5000);
        pageProvider.getSearchResultPage().checkIsRedirectToSearchResultPage();


    }

}
