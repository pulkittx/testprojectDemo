import helper.ConsoleLog;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPageWithChromeDriver;
import pages.MyProjectDashBoard;

public class RestAssuredDemoPostTest extends BaseTest {

    LoginPageWithChromeDriver loginPageWithChromeDriver;
    HomePage homePage;
    MyProjectDashBoard myProjectDashBoard;

    String userName = "pulkit.agarwal@testingxperts.com";
    String password = "Damco@123";
    String myFirstProjectOption = "My first Project";

    @Test
    public void postRequestDemoTest() throws Throwable {
        /**
         * UI test
         */
        loginPageWithChromeDriver = new LoginPageWithChromeDriver(driver);
        homePage = new HomePage(driver);
        myProjectDashBoard = new MyProjectDashBoard(driver);

        homePage = loginPageWithChromeDriver.login(userName, password);

        boolean isUserLoggedIn = homePage.isHomePageLogoDisplayed();

        driver.report().step("User logged in", isUserLoggedIn);
        Assert.assertTrue(isUserLoggedIn, "Homepage logo is not displayed");
        ConsoleLog.info("Homepage logo is displayed");

        /**
         * API test
         */
        String appName = "Youtube";
        String appUrl = "https://www.youtube.com/";

        RestAssured.baseURI = baseUrlApi;

        // Getting request specification
        RequestSpecification httpRequest = RestAssured.given();

        // Setting the request header
        httpRequest.header("Authorization", "iVDNC-jeL8mhP4lh3F1CjVYSQVPRk_sgGpT5cFAtbhI1");
        httpRequest.header("Content-Type", "application/json");

        // Setting the parameters for body
        JSONObject requestParams = new JSONObject();
        requestParams.put("name",appName);
        requestParams.put("description","Youtube web application");
        requestParams.put("platform","Web");
        requestParams.put("url",appUrl);

        // Adding the body
        httpRequest.body(requestParams);

        // Sending the post request
        Response response = httpRequest.request(Method.POST, "/v2/projects/nEP6rnMoz0qFv6WHG98VcQ/applications");

        // Verifying the status code
        ConsoleLog.info("Status code: "+response.getStatusCode());
        boolean statusCode = response.getStatusCode()==200;
        Assert.assertTrue(statusCode);
        driver.report().step("Created the application in the project successfully using api with status code: " + statusCode);
        ConsoleLog.info("API done");
        ConsoleLog.info("Resuming UI");

        /**
         * Resuming UI part
         */
        // Click on My Projects dropdown
        myProjectDashBoard = homePage.selectOptionInMyProjectDropdown(myFirstProjectOption);
        myProjectDashBoard.clickApplicationLink();

        boolean isRequiredAppDisplayed = myProjectDashBoard.isLinkDisplayedOnApplicationSection(appName);

        Assert.assertTrue(isRequiredAppDisplayed);
        ConsoleLog.info("Test completed");
        driver.report().test("UI and API test", isRequiredAppDisplayed).submit();
        //driver.report().test("UI and API test", isUserLoggedIn).submit();
    }
}
