package locators;

import io.testproject.sdk.drivers.web.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HomePageLocators extends BasePage {

    public HomePageLocators(ChromeDriver driver) {
        super(driver);

    }

    @FindBy(css = "a[href='#/home']")
    protected WebElement homePageLogo;

    @FindBy(xpath = "//div[contains(text(),'My Projects')]/../../div")
    protected WebElement myProjectsDropdown;

    @FindBy(css = "input[placeholder='Search a Project']")
    protected WebElement searchAProjectInputFieldInMyProjectDropdown;

    @FindBy(xpath = "//div[contains(text(),'My Projects')]/../../div")
    protected WebElement filteredElementInMyProjectsDropDown;

    public WebElement projectMenuBar(String s)
    {
        return driver.findElement(By.xpath("//div[@class='links']/a[contains(text(),"+ s +")]"));
    }
    /*@FindBy(xpath = "//div[@class='links']/a[contains(text(),'Project')]")
    protected WebElement projectMenuBar;
*/
    public WebElement projectNameFromMenuBar(String s)
    {
        return driver.findElement(By.xpath("//span[contains(text(),"+ s +")]"));
    }

    /*@FindBy(xpath = "//span[contains(text(),'My first Project')]")
    protected WebElement projectNameFromMenuBar;*/
}
