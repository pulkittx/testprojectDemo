package pages;

import io.testproject.sdk.drivers.web.ChromeDriver;
import locators.MyProjectDashBoardLocators;
import org.openqa.selenium.support.PageFactory;

public class MyProjectDashBoard extends MyProjectDashBoardLocators {
    ChromeDriver chromeDriver;
    public MyProjectDashBoard(ChromeDriver driver){
        super(driver);
        this.chromeDriver = driver;
        PageFactory.initElements(chromeDriver, this);
    }


}
