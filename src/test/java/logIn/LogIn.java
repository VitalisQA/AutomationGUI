package logIn;

import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by user on 05.12.2018.
 */
public class LogIn extends ParentTest {
    @Test
    public void validLogin() throws SQLException, IOException, ClassNotFoundException {
        mainPage.openMainPage();
        mainPage.headerMenuAndModals.checkIfLogedInThenLogOut();
        mainPage.headerMenuAndModals.clickButtonLogIn();
        mainPage.headerMenuAndModals.enterLogin("777770002");
        mainPage.headerMenuAndModals.clickButtonDalej();
        mainPage.headerMenuAndModals.enterPassword("1qaz@WSX");
        mainPage.headerMenuAndModals.clickButtonZalogujsię();

        checkExpectedResult("Header logout button is not present", profilePage.headerMenuAndModals.isHeaderLogoutLinkPresent());
    }
}
