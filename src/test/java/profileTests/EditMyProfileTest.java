package profileTests;

import baseTest.BaseTest;
import libs.RandomLettersGenerator;
import libs.Util;
import org.junit.Test;

import static libs.TestData.VALID_LOGIN_UI;
import static libs.TestData.VALID_PASSWORD_UI;


public class EditMyProfileTest extends BaseTest {
    final String randomName = RandomLettersGenerator.generateRandomLetters(6);
    final String CHANGED_NAME = "changedName" + randomName;

    @Test
    public void editMyProfile() throws InterruptedException {
        pageProvider.getHomePage()
                .openHomePage()
                .clickOnButtonSignIn()
                .checkIsRedirectToLoginPage()
                .fillLoginFormAndSubmit(VALID_LOGIN_UI, VALID_PASSWORD_UI);
        //Thread.sleep(5000);
        // pageProvider.getHomePage().checkIsRedirectToHomePage();
        pageProvider.getHomePage().getHeader().clickOnMyPanelButton();
        pageProvider.getMyPanelPage().clickOnMyAccountButton()
                .checkIsRedirectToMyAccountPage()
                .addTextToInputFirstName(CHANGED_NAME);
        //  .addTextToInputLastName("changedLastName")
        // .selectDayOfBirth("1")
        // .selectDiscount("Звичайний квиток")
        Thread.sleep(5000);

        pageProvider.getMyAccountPage().saveChanges();
        Thread.sleep(5000);

        pageProvider.getHomePage().getHeader().checkTextInMyOrdersBtn(CHANGED_NAME);
        ;
    }
}
