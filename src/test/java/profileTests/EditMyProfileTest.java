package profileTests;

import baseTest.BaseTest;
import org.junit.Test;

import static libs.TestData.VALID_LOGIN_UI;
import static libs.TestData.VALID_PASSWORD_UI;

public class EditMyProfileTest extends BaseTest {
    @Test
    public void editMyProfile() throws InterruptedException {
        pageProvider.getHomePage()
                .openHomePage()
                .clickOnButtonSignIn()
                .checkIsRedirectToLoginPage()
                .fillLoginFormAndSubmit(VALID_LOGIN_UI, VALID_PASSWORD_UI);
        Thread.sleep(5000);
        pageProvider.getHomePage().checkIsRedirectToHomePage();
        pageProvider.getHomePage().getHeader().clickOnMyPanelButton();
        pageProvider.getMyPanelPage().clickOnMyAccountButton()
                .checkIsRedirectToMyAccountPage()
                .addTextToInputFirstName("changedName")
                .addTextToInputLastName("changedLastName")
                .selectDayOfBirth("1")
                .selectDiscount("Karta Pracownika (ŁKA) - ulga 55%")
        ;
    }
}
