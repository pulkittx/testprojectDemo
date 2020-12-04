package helpers;

import helper.ConsoleLog;
import io.testproject.sdk.drivers.web.ChromeDriver;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

    ChromeDriver driver;
    WebDriverWait wait;
    private static Integer timeOut = 20;
    Select s;
    public CommonActions(ChromeDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOut);
    }

    public void verifyIsElementVisible(WebElement element) throws Throwable {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (ElementNotVisibleException e) {
            ConsoleLog.info("Element" + element + "is not visible");
            throw e.getCause();
        }
    }

    public void typeKeys(WebElement element, String input) throws Throwable {
        verifyIsElementVisible(element);
        ConsoleLog.info(element + "is displayed");
        try{
            element.sendKeys(input);
        }
        catch (Exception e){
            ConsoleLog.info("Couldn't perform type action with element: " + element);
            throw e.getCause();
        }

    }

    public void click(WebElement element) throws Throwable {
        verifyIsElementVisible(element);
        ConsoleLog.info(element + "is displayed");
        try{
            element.click();
        }
        catch (Exception e){
            ConsoleLog.info("Couldn't perform type action with element: " + element);
            throw e.getCause();
        }
    }

    public void selectOptionForNoSelectTag(WebElement dropDownElement, WebElement textFieldElement, WebElement filteredElement, String optionText) throws Throwable {
        click(dropDownElement);
        typeKeys(textFieldElement, optionText);
        click(filteredElement);
    }

    public boolean verifyElementIsDisplayed(WebElement element) throws Throwable {
        verifyIsElementVisible(element);
        return element.isDisplayed();
    }

    public void hoverOver(WebElement element) {

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            (new Actions(this.driver)).moveToElement(element).perform();

        } catch (Exception e) {
            ConsoleLog.info("Hover over element did not work as expected." + element);
        }
    }
}
