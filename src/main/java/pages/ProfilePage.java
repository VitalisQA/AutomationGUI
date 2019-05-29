package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.elements.HeaderMenuAndModals;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * Created by user on 06.12.2018.
 */
public class ProfilePage extends ParentPage {

    public HeaderMenuAndModals headerMenuAndModals = new HeaderMenuAndModals(webDriver);

    @FindBy(xpath = "//a[@class='header__logout-link']") private Link headerLogoutLink;


    public ProfilePage(WebDriver webDriver) {
        super(webDriver, "/#/profile");
    }

//    public boolean isHeaderLogoutLinkPresent() {
//        wait5.until(ExpectedConditions.visibilityOf(headerLogoutLink));
//        return actionsWithOurElements.isElementPresent(headerLogoutLink);
//    }
}
