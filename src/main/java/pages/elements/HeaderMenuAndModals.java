package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by user on 17.01.2019.
 */

    @FindBy(xpath = "//div[@class='container header__content']")
    public class HeaderMenuAndModals extends ParentElements{

    @FindBy(xpath = "//a[@class='header__reset_password-link']")
    private Link headerResetPasswordLink;

    @FindBy(name = "newPassword")
    private TextInput modalNewPasswordInput;

    @FindBy(name = "newPasswordConfirmation")
    private TextInput modalNewPasswordConfirmationInput;

    @FindBy(xpath = "//button[@class='color-white md-accent md-primary large pull-right md-raised md-hue-1 w600 md-button md-ink-ripple']")
    private Button modalZminaHaslaButton;

    @FindBy(xpath = "//a[@class='header__logout-link']")
    private Link logOutLink;

    @FindBy(xpath = "//a[@class='header__login-link background-orange']")
    private Button logInButton;

    @FindBy(xpath = "//input[@name='phone'][@input-focus='']")
    private TextInput loginModalLoginInput;

    @FindBy(xpath = "//button[@class='md-accent md-raised md-hue-1 no-m-l color-white w600 md-button ng-scope md-ink-ripple']")
    private Button loginModalDalejButton, loginModalZalogujsięButton;

    @FindBy(xpath = "//input[@name='password']")
    private TextInput loginModalPasswordInput;

    @FindBy(xpath = "//a[@class='header__personal_data-link ng-scope']")
    private Link shesterenka;

    @FindBy(xpath = "//span[contains(text(),'Tak')]")
    private Button logoutModalSubmitButton;

//    @FindBy(xpath = "//span[contains(text(),'change password')]")
//    private Button changePasswordButton;
//    @FindBy(xpath = "//input[@ng-model='newPassword']")
//    private TextInput changePasswordModalNewPasswordInput;
//    @FindBy(xpath = "//input[@ng-model='newPasswordConfirmation']")
//    private TextInput changePasswordModalNewPasswordConfirmationInput;
//    @FindBy(xpath = "//span[@class='ng-scope'][contains(text(),'Zmiana hasła')]")
//    private Button zmianaHasłaButton;

    public HeaderMenuAndModals(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterNewPassword(String newPassword) {
        actionsWithOurElements.enterTextInToElement(modalNewPasswordInput,newPassword);
    }

    public void enterNewPasswordConfirmation(String newPasswordConfirmation) {
        actionsWithOurElements.enterTextInToElement(modalNewPasswordConfirmationInput, newPasswordConfirmation);
    }

    public void clickOnZminaHaslaButton(){
        actionsWithOurElements.clickOnElement(modalZminaHaslaButton);
    }

    public void clickOnHeaderResetPasswordLink(){
        actionsWithOurElements.clickOnElement(headerResetPasswordLink);
    }

    public void checkIfLogedInThenLogOut() {
        if (actionsWithOurElements.isElementPresent(logOutLink)) {
            actionsWithOurElements.clickOnElement(logOutLink);
            actionsWithOurElements.clickOnElement(logoutModalSubmitButton);
        }
    }

    public void clickOnShesterenka() {
        actionsWithOurElements.clickOnElement(shesterenka);
    }

    public void clickButtonLogIn() {
        actionsWithOurElements.clickOnElement(logInButton);
    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextInToElement(loginModalLoginInput, login);
    }

    public void clickButtonDalej() {
        actionsWithOurElements.clickOnElement(loginModalDalejButton);
    }

    public void enterPassword(String password) {
        actionsWithOurElements.enterTextInToElement(loginModalPasswordInput, password);
    }

    public void clickButtonZalogujsię() {
        actionsWithOurElements.clickOnElement(loginModalZalogujsięButton);
    }

    public boolean isHeaderLogoutLinkPresent() {
        wait5.until(ExpectedConditions.visibilityOf(logOutLink));
        return actionsWithOurElements.isElementPresent(logOutLink);
    }

}
