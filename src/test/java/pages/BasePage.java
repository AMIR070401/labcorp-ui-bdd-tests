package pages;

import common.SharedDriver;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.Logger;

public class BasePage {

    protected final SharedDriver driver;
    WebDriverWait wait;
    private final Logger log = LogManager.getLogger(BasePage.class);

    /**
     * * Description: Constructor to initialize driver and add implicit wait
     * * Author: AMIR AHMAD
     */
    public BasePage(SharedDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(20));
    }

    /**
     * * Description: Method to click on given element on the basis of By
     * * Author: AMIR AHMAD
     */
    public void click(By by) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.click();
    }

    /**
     * * Description: Method to click on given element
     * * Author: AMIR AHMAD
     */
    public void click(WebElement element) {
        element.click();
    }

    /**
     * * Description: Method to get specific element
     * * Author: AMIR AHMAD
     */
    public WebElement getElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * * Description: Method to enter text on given element
     * * Author: AMIR AHMAD
     */
    public void enterText(By by, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear();
        element.sendKeys(text);
    }

    /**
     * * Description: Method to get text of a given element
     * * Author: AMIR AHMAD
     */
    public String getText(By by) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getText();
    }

    /**
     * * Description: Method to get the list of elements
     * * Author: AMIR AHMAD
     */
    public List<WebElement> getElementList(By by) {
        return driver.getDriver().findElements(by);
    }

    /**
     * * Description: Method to click on a specific button and switch to a new window
     * * Author: AMIR AHMAD
     */
    public void clickButtonAndSwitchWindow(WebElement element) {
        String parent_window = driver.getDriver().getWindowHandle();
        click(element);
        Set<String> windows = driver.getDriver().getWindowHandles();
        if(windows.size() < 2) {
            log.error("There is just 1 window present. Cannot switch to another window.");
        }
        String child_window = "";
        for(String window:windows) {
            if(!window.equalsIgnoreCase(parent_window)) {
                child_window = window;
            }
        }
        driver.getDriver().switchTo().window(child_window);
    }
}
