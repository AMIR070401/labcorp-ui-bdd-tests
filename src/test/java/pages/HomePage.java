package pages;

import common.SharedDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private final Logger log = LogManager.getLogger(HomePage.class);
    private final static String careerLink = "Careers";
    protected final SharedDriver driver;

    /**
     * * Description: Constructor to initialize driver
     * * Author: AMIR AHMAD
     */
    public HomePage(SharedDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * * Description: Method to click on career link on Home page
     * * Author: AMIR AHMAD
     */
    public CareerPage clickOnCareerLink() {
        click(By.linkText(careerLink));
        log.info("Clicking on Careers link is successful");
        return new CareerPage(driver);
    }
}
