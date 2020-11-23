package testprojectsio;

import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {

    protected static ChromeDriver driver;
    private static Properties properties;
    private static String baseURL;
    private static String devToken;

    @BeforeSuite
    public void testConfig() throws IOException {
        //System.setProperty("webdriver.chrome.driver", "D:\\Tools\\chromedriver.exe");
        properties = new Properties();
        String propFileName = "common.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }

        baseURL = properties.getProperty("url");
        devToken = properties.getProperty("dev_token");
    }
    @BeforeMethod
    public void setUp() throws IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException {

        driver = new DriverBuilder<ChromeDriver>(new ChromeOptions())
                .withRemoteAddress(new URL("http://localhost:8585"))
                .withToken(devToken)
                .withProjectName("OrangeHRM").withJobName("orangeHRMJob")
                .build(ChromeDriver.class);



        //driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.navigate().to(baseURL);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
