import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.MessageFormat;

public class RestAssuredDemoPostTest extends BaseTest {

    @Test
    public void postRequestDemoTest() throws InvalidTokenException, AgentConnectException, ObsoleteVersionException, IOException, InterruptedException {
        /**
         * UI test
         */
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("pulkit.agarwal@testingxperts.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Damco@123");
        driver.findElement(By.xpath("//input[@id='tp-sign-in']")).click();
        Thread.sleep(11000);
        boolean isUserLoggedIn = driver.findElement(By.cssSelector("a[href='#/home']")).isDisplayed();
        driver.report().step("User logged in", isUserLoggedIn);

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
        System.out.println("Status code: "+response.getStatusCode());
        boolean statusCode = response.getStatusCode()==200;
        Assert.assertTrue(statusCode);
        driver.report().step("Created the application in the project successfully using api with status code: " + statusCode);
        System.out.println("API done");
        System.out.println("Resuming UI");

        /**
         * Resuming UI part
         */
        // Click on My Projects dropdown
        driver.findElement(By.xpath("//div[contains(text(),'My Projects')]/../../div")).click();
        driver.report().step("User clicked on my project");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("input[placeholder='Search a Project']")).sendKeys("My first Project");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("div[title='Initial project']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div//span[contains(text(),'Applications')]")).click();
        Thread.sleep(3000);

        boolean isRequiredAppDisplayed = driver.findElement(By.cssSelector(MessageFormat.format("div[title=''{0}'']", appName))).isEnabled();

        Assert.assertTrue(isRequiredAppDisplayed);

        driver.report().test("UI and API test", isRequiredAppDisplayed).submit();
    }
}
