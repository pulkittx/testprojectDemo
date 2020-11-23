package Data;

import org.testng.annotations.DataProvider;

public class DataContainerClass {

    @DataProvider(name = "credentials")
    public Object[][] loginCredentials(){
        return new Object[][]{
            {"Admin","admin123"},
            {"Admin1", "admin123"},
            {"Admin2", "admin123"}
        };
    }
}
