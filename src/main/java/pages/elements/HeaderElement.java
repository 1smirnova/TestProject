package pages.elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;


public class HeaderElement extends CommonActionsWithElements{
    @FindBy(xpath="//*[@href='/my/orders']")
    private HeaderElement myOrdersBtn;
    @FindBy(xpath="//*[@href='/my']")
    private HeaderElement myProfileBtn;


    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }
}
