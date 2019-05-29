package logIn;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by user on 06.12.2018.
 */
public class Authorization extends ParentTest {
    @Before
    public void deleteDataFromDB () throws SQLException, IOException, ClassNotFoundException {
        utilsForDB.clearEverythingFromAuiByPhone("777770007");
    }
    @Test
    public void newUserRegistration() throws SQLException, IOException, ClassNotFoundException {

        mainPage.openMainPage();
        mainPage.applyingForBalloonLoanWithDefaultValues();
        authPage.checkUrl();
        authPage.enterName("Max");
        authPage.enterLastName("Espresso");
        authPage.enterPhone("777770007");
        authPage.setCheckboxAgreedToConditions("check");
//TODO  authPage.setCheckBoxAgreedToMarketingDistribution("check");
        authPage.clickOnButtonDalej();
        employmentPage.isEmploymentPageDisplaed();

        checkExpectedResult("User wasn't registered",
                utilsForDB.isUserRegistered("777770007"));
    }

}
