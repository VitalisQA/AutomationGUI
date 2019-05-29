package parentTest;

import libs.UtilsForDB;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AuthPage;
import pages.EmploymentPage;
import pages.MainPage;
import pages.ProfilePage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 05.12.2018.
 */
public class ParentTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected MainPage mainPage;
    protected ProfilePage profilePage;
    public UtilsForDB utilsForDB;
    protected AuthPage authPage;
    protected EmploymentPage employmentPage;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        mainPage = new MainPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        authPage = new AuthPage(webDriver);
        employmentPage = new EmploymentPage(webDriver);
        utilsForDB = new UtilsForDB();
        }

    @After
    public void tearDown() throws SQLException {

        webDriver.quit();
    }

    public void checkExpectedResult(String message, boolean actualResult, boolean expectedResult) {
        Assert.assertEquals(message, expectedResult, actualResult);
    }

    public void checkExpectedResult(String mesage, boolean actualResult) {
        checkExpectedResult(mesage, actualResult, true);
    }
}


