package pages;

import io.testproject.sdk.drivers.web.ChromeDriver;
import locators.HomePageLocators;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends HomePageLocators {
    ChromeDriver chromeDriver;

    public HomePage(ChromeDriver driver) {
        super(driver);
        this.chromeDriver = driver;
        PageFactory.initElements(chromeDriver, this);
    }

    public boolean isHomePageLogoDisplayed() throws Throwable {
        return commonActions.verifyElementIsDisplayed(homePageLogo);
    }

    public MyProjectDashBoard selectOptionInMyProjectDropdown(String optionText) throws Throwable {
        commonActions.selectOptionForNoSelectTag(myProjectsDropdown, searchAProjectInputFieldInMyProjectDropdown, filteredElementInMyProjectsDropDown, optionText);
        return new MyProjectDashBoard(chromeDriver);
    }

    public void hoverOverProjectMenuBar(String name) throws Throwable {
        commonActions.hoverOver(projectMenuBar(name));

    }

    public void selectProjectFromMenuBar(String value) throws Throwable {
        commonActions.click(projectNameFromMenuBar(value));
    }
}
