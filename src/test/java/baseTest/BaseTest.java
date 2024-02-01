package baseTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageProvider;
import pages.ParentPage;

import java.time.Duration;


public class BaseTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected PageProvider pageProvider;

    //Буде виконуватися перед кожним тестом
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();//встановлюємо драйвер
        webDriver = new ChromeDriver();//створюємо екземпляр драйвера
        webDriver.manage().window().maximize();//розгортаємо вікно на весь екран
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Browser was opened");//логуємо, що браузер відкрито
        pageProvider = new PageProvider(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }

}
