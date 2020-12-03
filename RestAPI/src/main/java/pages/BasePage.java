package pages;

import helpers.CommonActions;
import io.testproject.sdk.drivers.web.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected static CommonActions commonActions;
    protected ChromeDriver driver;

    public BasePage(ChromeDriver driver){
        this.driver = driver;
        commonActions = new CommonActions(driver);
    }

    public WebElement getElementByXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
}
