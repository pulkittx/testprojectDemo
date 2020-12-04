package helpers;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderUtils {

   /* @DataProvider(name = "testdata")
    public Object[][] data(Method m) throws IOException {
        System.out.println("Dataprovider");
        String s[] = ((Test) m.getAnnotation(Test.class)).parameters();
        System.out.println(s[0]);
        System.out.println(s[1]);
        excelUtls excel = new excelUtls(s[0], s[1]);
        Object[][] data = excelUtls.testData(excel);
        return data;
   */ }

