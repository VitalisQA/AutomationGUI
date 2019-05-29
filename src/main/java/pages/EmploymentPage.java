package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by user on 15.12.2018.
 */
public class EmploymentPage extends ParentPage {
    public EmploymentPage(WebDriver webDriver) {
        super(webDriver, "/#/employment");
    }

    public boolean isEmploymentPageDisplaed() {
        try {
            wait10.until(ExpectedConditions.urlContains(expectedUrl));
            return webDriver.getCurrentUrl().contains(expectedUrl);

        } catch (Exception e) {
            logger.info("\"About Me\" form was not displayed");
            return false;
        }
    }
}
