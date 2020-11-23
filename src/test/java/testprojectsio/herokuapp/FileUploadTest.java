package testprojectsio.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import testprojectsio.BaseTest;
import utilities.FileUtility;

import java.net.URISyntaxException;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() throws URISyntaxException {
        FileUtility fileUtility = new FileUtility();
        fileUtility.getFileResourcePath("doc-sample1.docx");
        String filePath = "D:\\testproject\\src\\test\\resources\\doc-sample1.docx";

        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        boolean fileUploadedFlag = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]")).isDisplayed();
        Assert.assertTrue(fileUploadedFlag);
    }
}
