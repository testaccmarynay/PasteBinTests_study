package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// I've taken this config idea somewhere in the Net

public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    static {
        try {
            // show path to config values
            fileInputStream = new FileInputStream("src/test/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
            // exceptions
            }
        finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                }
            catch (IOException e) {
                    e.printStackTrace();
            }
        }
    }
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
