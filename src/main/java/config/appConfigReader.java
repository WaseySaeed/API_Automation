package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class appConfigReader {

    protected static Properties prop = new Properties();
    String fileName = "src/main/resources/app.properties";

    public appConfigReader() {
        try {
            InputStream input = new FileInputStream(fileName);
            prop.load(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }

    public String getApiKey() {
        return prop.getProperty("apiKey");
    }

    public String getApiHost()
    {
        return prop.getProperty("apiHost");
    }

}
