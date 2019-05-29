package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.elements.HeaderMenuAndModals;
import ru.yandex.qatools.htmlelements.element.*;

/**
 * Created by user on 05.12.2018.
 */
public class MainPage extends ParentPage {
    protected ProfilePage profilePage = new ProfilePage(webDriver);

    public HeaderMenuAndModals headerMenuAndModals = new HeaderMenuAndModals(webDriver);



    @FindBy (xpath = "//label[@for='agreed1']")
    private CheckBox checkBoxAgreedWithMarketingDistr;
    @FindBy(xpath = "//div[@class='product product--first visible']//a[@class='btn-main btn-main--has-arrow ng-scope'][contains(text(),'Dalej')]")
    private Button submitBalloonButton;
    @FindBy(xpath = "//div[@class='product-type product-type--first active']")
    private Link vkladkaBalloon;



    public MainPage(WebDriver webDriver) {
        super(webDriver, "/#/");
    }

    public void openMainPage() {
        try {
            webDriver.get("http://test.ekassa.com");
            logger.info("Main page was opened");
        } catch (Exception e) {
            logger.info("Can not open Main Page");
            Assert.fail("Can not open Main Page");
        }
    }

    public void applyingForBalloonLoanWithDefaultValues() {
        actionsWithOurElements.clickOnElement(vkladkaBalloon);
        actionsWithOurElements.clickOnElement(checkBoxAgreedWithMarketingDistr);
        actionsWithOurElements.clickOnElement(submitBalloonButton);
    }

    public void validLogInWithGivenCreds(String login,String password) {
        openMainPage();
        headerMenuAndModals.checkIfLogedInThenLogOut();
        headerMenuAndModals.clickButtonLogIn();
        headerMenuAndModals.enterLogin(login);
        headerMenuAndModals.clickButtonDalej();
        headerMenuAndModals.enterPassword(password);
        headerMenuAndModals.clickButtonZalogujsię();
    }

    public boolean isNewPasswordSet(String login, String newPassword) {
        try {
            validLogInWithGivenCreds(login,newPassword);
            return headerMenuAndModals.isHeaderLogoutLinkPresent();
        }catch (Exception e){
            return false;
        }

    }
}
