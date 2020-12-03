package pages;

import helpers.CommonActions;
import io.testproject.sdk.drivers.web.ChromeDriver;

public abstract class BasePage {
    protected static CommonActions commonActions;

    public BasePage(ChromeDriver driver){
        commonActions = new CommonActions(driver);
    }
}
