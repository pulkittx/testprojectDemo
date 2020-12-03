package locators;

import io.testproject.sdk.drivers.web.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HomePageLocators extends BasePage {

    public HomePageLocators(ChromeDriver driver){
        super(driver);
    }

    @FindBy(css = "a[href='#/home']")
    protected WebElement homePageLogo;

    @FindBy(xpath = "//div[contains(text(),'My Projects')]/../../div")
    protected WebElement myProjectsDropdown;

    @FindBy(css = "input[placeholder='Search a Project']")
    protected WebElement searchAProjectInputFieldInMyProjectDropdown;

    @FindBy()
    protected WebElement filteredElementInMyProjectsDropDown;
}
