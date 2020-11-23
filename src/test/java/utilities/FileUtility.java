package utilities;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class FileUtility {

    public String getFileResourcePath(String fileName) throws URISyntaxException {
        URL res = getClass().getClassLoader().getResource(fileName);
        File file = Paths.get(res.toURI()).toFile();
        return file.getAbsolutePath();
    }
}
