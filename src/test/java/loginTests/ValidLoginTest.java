package loginTests;

import baseTest.BaseTest;
import org.junit.Test;

import static libs.TestData.VALID_LOGIN_UI;
import static libs.TestData.VALID_PASSWORD_UI;

public class ValidLoginTest extends BaseTest {
    @Test
    public void validLogin() throws InterruptedException {
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .clickOnButtonSignIn()
                .fillLoginFormAndSubmit(VALID_LOGIN_UI, VALID_PASSWORD_UI);
        pageProvider.getHomePage()
                .getHeader().checkIsButtonMyPanelVisible()
                .checkIsButtonMyOrdersVisible()
        ;
        // Thread.sleep(5000);
        pageProvider.getLoginPage().checkIsInputUsernameNotPresent()
                .checkIsInputPasswordNotPresent()
        ;
    }
}
