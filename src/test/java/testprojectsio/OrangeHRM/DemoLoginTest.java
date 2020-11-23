package testprojectsio.OrangeHRM;

import Data.DataContainerClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import testprojectsio.BaseTest;

public class DemoLoginTest extends BaseTest {

    @Test(dataProvider = "credentials", dataProviderClass = DataContainerClass.class)
    public void logInTest(String userName, String password) {
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys(userName);
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("#btnLogin")).click();

        boolean passed = BaseTest.driver.findElement(By.cssSelector("#welcome")).isDisplayed();
        Assert.assertTrue(passed);
    }
}
