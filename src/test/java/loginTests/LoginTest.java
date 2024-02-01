package loginTests;

import baseTest.BaseTest;
import org.junit.Test;

import static libs.TestData.VALID_LOGIN_UI;
import static libs.TestData.VALID_PASSWORD_UI;

public class LoginTest extends BaseTest {
    private static final String INVALID_LOGIN_UI = "anastasiia.smirnova.qainvalid@gmail.com";

    @Test
    public void validLogin(){
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .clickOnButtonSignIn()
                .checkIsRedirectToLoginPage()
                .fillLoginFormAndSubmit(VALID_LOGIN_UI, VALID_PASSWORD_UI);
        pageProvider.getHomePage()
                .getHeader().checkIsButtonMyPanelVisible()
                .checkIsButtonMyOrdersVisible()
        ;
        pageProvider.getLoginPage().checkIsInputUsernameNotPresent()
                .checkIsInputPasswordNotPresent()
        ;
    }

    @Test
    public void invalidLogin() {
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .clickOnButtonSignIn()
                .fillLoginFormAndSubmit(INVALID_LOGIN_UI, VALID_PASSWORD_UI);
        pageProvider.getLoginPage()
                .checkIsButtonSignInPresent()
                .checkIsInputUsernamePresent()
                .checkIsInputPasswordPresent()
                .checkAlertWithTextIsPresent("Niepoprawny email lub hasło.")
        ;
        pageProvider.getHomePage()
                .getHeader().checkIsButtonMyPanelNotVisible()
                .checkIsButtonMyOrdersNotVisible()
        ;
    }
}
