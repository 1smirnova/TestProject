package searchTests;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static libs.TestData.VALID_LOGIN_UI;
import static libs.TestData.VALID_PASSWORD_UI;

@RunWith(JUnitParamsRunner.class)

public class SearchTest extends BaseTest {
    final String DATE = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(LocalDateTime.now().plusDays(3));

    @Test
    @Parameters(method = "parametersForSearchTests")

    public void searchTest(String from, String to, String date) {
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .clickOnButtonSignIn()
                .checkIsRedirectToLoginPage()
                .fillLoginFormAndSubmit(VALID_LOGIN_UI, VALID_PASSWORD_UI);
        pageProvider.getHomePage().enterFrom(from)
                .enterTo(to)
                .enterDate(date)
                .clickOnButtonSearch();
        pageProvider.getSearchResultPage().checkIsRedirectToSearchResultPage();
        pageProvider.getSearchResultPage().checkTextInTitle(from)
                .checkTextInTitle(to);
    }

    private Object[][] parametersForSearchTests() {
        return new Object[][]{
                {"Wrocław Główny", "Warszawa Centralna", DATE},
                {"Poznań Główny", "Warszawa Centralna", DATE},
                {"Kraków Główny", "Warszawa Centralna", DATE},
                {"Gdańsk Główny", "Warszawa Centralna", DATE},
                {"Szczecin Główny", "Warszawa Centralna", DATE}
        };
    }

    @Test
    public void invalidDateTest() {
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .clickOnButtonSignIn()
                .checkIsRedirectToLoginPage()
                .fillLoginFormAndSubmit(VALID_LOGIN_UI, VALID_PASSWORD_UI);
        pageProvider.getHomePage().enterFrom("Wrocław Główny")
                .enterTo("Warszawa Centralna")
                .enterDate("02-02-2025 00:00")
                .clickOnButtonSearch();
        pageProvider.getSearchResultPage().checkIsRedirectToSearchResultPage()
                .checkAlertWithTextIsPresent("Zbyt daleka data wyszukania (ponad 30 dni od dzisiaj). Spróbuj wcześniejszego terminu.");
    }

    @Test
    public void promoIsDisplayedAfterTicketConfirmation() {
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .clickOnButtonSignIn()
                .checkIsRedirectToLoginPage()
                .fillLoginFormAndSubmit(VALID_LOGIN_UI, VALID_PASSWORD_UI);
        pageProvider.getHomePage().enterFrom("Wrocław Główny")
                .enterTo("Warszawa Centralna")
                .enterDate(DATE)
                .clickOnButtonSearch();
        pageProvider.getSearchResultPage().checkIsRedirectToSearchResultPage()
                .clickOnBuyTicket();
        pageProvider.getSearchResultPage().checkPassengerInfoIsDisplayed()
                .clickOnButtonConfirmOrder();
        pageProvider.getTravelOptionsPage().checkIsRedirectToTravelOptionsPage().checkTextInTravelOptionsTitle("Wrocław Główny — Warszawa Centralna")
                .clickOnButtonConfirmOrder();
        pageProvider.getTravelOptionsPage().checkPromoTitle("Dźwigniemy to za Ciebie!");
    }
}
