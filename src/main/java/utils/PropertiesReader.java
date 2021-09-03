package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    Properties property = new Properties();

    public PropertiesReader() {
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            fis.close();
        } catch (
                IOException e) {
            System.err.println("Properties file is not exist");
        }
    }

    public String getURL() {
        return property.getProperty("URL");
    }

    public String getDriverName() {
        return property.getProperty("CHROME_DRIVER_NAME");
    }

    public String getDriverLocation() {
        return property.getProperty("CHROME_DRIVER_LOCATION");
    }
}