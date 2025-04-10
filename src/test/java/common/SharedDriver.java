package common;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class SharedDriver {
    private static WebDriver driver = null;
    private static Properties p;

    /**
     * * Description: Constructor to initialize driver and add implicit wait
     * * Author: AMIR AHMAD
     */
    public SharedDriver() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        p = new Properties();
        p.load(fis);
        getBaseWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * * Description: Method to return current instance of driver
     * * Author: AMIR AHMAD
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * * Description: Method to get driver specific WebDriver based on browser value provided in config.properties file
     * * Author: AMIR AHMAD
     */
    public static void getBaseWebDriver() {
        Browser browser = Browser.valueOf(p.getProperty("browser").toUpperCase());
        switch (browser) {
            case CHROME: {
                driver = new ChromeDriver();
                break;
            }
            case FIREFOX: {
                driver = new FirefoxDriver();
                break;
            }
            case EDGE: {
                driver = new EdgeDriver();
                break;
            }
            default:
                break;
        }
    }
}
