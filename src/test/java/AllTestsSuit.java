import loginTests.LoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import profileTests.EditMyProfileTest;
import searchTests.SearchTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTest.class,
                EditMyProfileTest.class,
                SearchTest.class
        }
)

public class AllTestsSuit {
}
