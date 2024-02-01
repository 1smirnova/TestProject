package profileTests;

import baseTest.BaseTest;
import libs.RandomLettersGenerator;
import org.junit.Test;

import static libs.TestData.VALID_LOGIN_UI;
import static libs.TestData.VALID_PASSWORD_UI;


public class EditMyProfileTest extends BaseTest {
    final String randomName = RandomLettersGenerator.generateRandomLetters(6);
    final String CHANGED_NAME = "changedName" + randomName;

    @Test
    public void changeProfileName() {
        pageProvider.getHomePage()
                .openHomePage()
                .clickOnButtonSignIn()
                .checkIsRedirectToLoginPage()
                .fillLoginFormAndSubmit(VALID_LOGIN_UI, VALID_PASSWORD_UI);
        pageProvider.getHomePage().getHeader().clickOnMyPanelButton();
        pageProvider.getMyPanelPage().clickOnMyAccountButton()
                .checkIsRedirectToMyAccountPage()
                .addTextToInputFirstName(CHANGED_NAME);
        pageProvider.getMyAccountPage().saveChanges();
        pageProvider.getHomePage().getHeader().checkTextInMyOrdersBtn(CHANGED_NAME);
    }
}
