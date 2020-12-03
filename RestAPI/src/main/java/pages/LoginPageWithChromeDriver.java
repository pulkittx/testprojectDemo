package pages;

import io.testproject.sdk.drivers.web.ChromeDriver;
import locators.LoginPageLocators;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageWithChromeDriver extends LoginPageLocators {
    ChromeDriver chromeDriver;

    public LoginPageWithChromeDriver(ChromeDriver driver) {
        super(driver);
        this.chromeDriver = driver;
        PageFactory.initElements(chromeDriver, this);
    }

    public void setUserName(String userNameText) throws Throwable {
        commonActions.typeKeys(userName, userNameText);
    }

    public void setPassword(String passwordText) throws Throwable {
        commonActions.typeKeys(password, passwordText);
    }

    public void clickSignInButton() throws Throwable {
        commonActions.click(signInButton);
    }
}
