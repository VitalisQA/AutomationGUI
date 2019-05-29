package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by user on 14.12.2018.
 */
public class AuthPage extends ParentPage {
    @FindBy (name = "name")
    private TextInput nameInput;
    @FindBy (name = "lastName")
    private TextInput lastNameInput;
    @FindBy(name = "phone")
    private TextInput phoneInput;
    @FindBy (xpath = "//md-checkbox[@name='agreedToConditions']")
    private CheckBox agreedToConditionsCheckbox;
    @FindBy (xpath = "//md-checkbox[@name='agreedToMarketingDistribution']")
    private CheckBox agreedToMarketingDistributionCheckbox;
    @FindBy(xpath = "//button[@type='submit']")
    private Button buttonDalej;

    public AuthPage(WebDriver webDriver) {
        super(webDriver, "/#/auth");
    }

    public void enterName(String name) {
        actionsWithOurElements.enterTextInToElement(nameInput,name);
    }

    public void enterLastName(String lastName) {
        actionsWithOurElements.enterTextInToElement(lastNameInput,lastName);
    }

    public void enterPhone(String phone) {
        actionsWithOurElements.enterTextInToElement(phoneInput, phone);
    }

    public void setCheckboxAgreedToConditions(String state) {
        actionsWithOurElements.setNeededStateToCheckBox(agreedToConditionsCheckbox,state);
    }

    public void setCheckBoxAgreedToMarketingDistribution(String state) {
        actionsWithOurElements.setNeededStateToCheckBox(agreedToMarketingDistributionCheckbox,state);
    }

    public void clickOnButtonDalej() {
        actionsWithOurElements.clickOnElement(buttonDalej);
//        wait10.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(agreedToConditionsCheckbox)));
    }
}
