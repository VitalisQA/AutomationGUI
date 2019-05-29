package pages.elements;

import libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

abstract public class ParentElements {
    WebDriver webDriver;
    ActionsWithOurElements actionsWithOurElements;
    WebDriverWait wait5, wait10;


    public ParentElements(WebDriver webDriver) {
        this.webDriver = webDriver;

        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)), this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        wait5 = new WebDriverWait(webDriver, 5);
        wait10 = new WebDriverWait(webDriver,10);
    }
}