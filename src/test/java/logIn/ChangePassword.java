package logIn;

import org.junit.AfterClass;
import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by user on 19.12.2018.
 */
public class ChangePassword extends ParentTest {

    @Test
    public void changePassByHeaderLink (){
        mainPage.validLogInWithGivenCreds("777770002","1qaz@WSX");
        mainPage.headerMenuAndModals.clickOnHeaderResetPasswordLink();
        mainPage.headerMenuAndModals.enterNewPassword("1qaz@WSXXX");
        mainPage.headerMenuAndModals.enterNewPasswordConfirmation("1qaz@WSXXX");
        mainPage.headerMenuAndModals.clickOnZminaHaslaButton();

        checkExpectedResult("Password was not changed", mainPage.isNewPasswordSet("777770002","1qaz@WSXXX"));

        mainPage.headerMenuAndModals.clickOnHeaderResetPasswordLink();
        mainPage.headerMenuAndModals.enterNewPassword("1qaz@WSX");
        mainPage.headerMenuAndModals.enterNewPasswordConfirmation("1qaz@WSX");
        mainPage.headerMenuAndModals.clickOnZminaHaslaButton();
    }

}
