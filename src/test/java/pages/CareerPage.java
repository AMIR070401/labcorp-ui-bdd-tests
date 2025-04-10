package pages;

import common.SharedDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class CareerPage extends BasePage{
    protected final SharedDriver driver;
    private final Logger log = LogManager.getLogger(CareerPage.class);
    private final static String searchBox = "//input[@id='typehead']";
    private final static String searchButton = "//button[@id='ph-search-backdrop']";
    private final static String listItem = "//li[@class='jobs-list-item']";
    private final static String jobTitleXpath = "//h1[@class='job-title']";
    private final static String locationXpath = "//span[@class='au-target job-location']";
    private final static String jobIdXpath = "//span[@class='au-target jobId']";
    private final static String remoteOptionXpath = "//span[@class='au-target remote']";
    private final static String qualificationsXpath = "//*[text()='Qualifications:']/parent::div//li/span";

    /**
     * * Description: Constructor to initialize driver
     * * Author: AMIR AHMAD
     */
    public CareerPage(SharedDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * * Description: Method to search for job on Career page
     * * Author: AMIR AHMAD
     */
    public CareerPage searchJob(String jobTitle) {
        enterText(By.xpath(searchBox), jobTitle);
        click(By.xpath(searchButton));
        log.info("Search job was successful ");
        return this;
    }

    /**
     * * Description: Method to click on matching job
     * * Author: AMIR AHMAD
     */
    public CareerPage clickMatchingJob(String jobTitle) {
        String text = getText(By.xpath(listItem));
        if (text.contains(jobTitle)) {
            click(By.partialLinkText(jobTitle));
            log.info("Click on matching job was successful ");
        }
        else {
            log.error("There is no job matching the given title");
            Assert.fail("There is no job matching the given title");
        }
        return this;
    }

    /**
     * * Description: Method to verify jo details on Career page
     * * Author: AMIR AHMAD
     */
    public CareerPage verifyJobDetails(String jobTitle, String location, String jobId, String remoteOption, String automationTool, String codingLanguage) {
        String jobTitleText = getText(By.xpath(jobTitleXpath));
        String locationText = getText(By.xpath(locationXpath));
        String jobIdText = getText(By.xpath(jobIdXpath));
        String remoteOptionText = getText(By.xpath(remoteOptionXpath));

        List<WebElement> elementList = getElementList(By.xpath(qualificationsXpath));

        if(elementList.isEmpty()) {
            log.error("Qualifications are not present");
        }

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(jobTitleText.contains(jobTitle), "Job Title does not match");
        softAssert.assertTrue(locationText.contains(location), "Location does not match");
        softAssert.assertTrue(jobIdText.contains(jobId), "Job ID does not match");
        softAssert.assertTrue(remoteOptionText.contains(remoteOption), "Remote option does not match");

        boolean isAutomationToolPresent = false;
        boolean isCodingLanguagePresent = false;

        for (WebElement element:elementList) {
            if(element.getText().contains(automationTool))
                isAutomationToolPresent = true;

            if(element.getText().contains(codingLanguage))
                isCodingLanguagePresent = true;
        }

        softAssert.assertTrue(isAutomationToolPresent, "Automation tool does not match");
        softAssert.assertTrue(isCodingLanguagePresent, "Coding Language does not match");

        softAssert.assertAll();

        return this;
    }

    /**
     * * Description: Method to click on Apply button
     * * Author: AMIR AHMAD
     */
    public JobApplicationPage clickApplyButton() {
        clickButtonAndSwitchWindow(getElement(By.linkText("Apply Now")));
        log.info("Clicking on Apply button and switching window is successful");
        return new JobApplicationPage(driver);
    }
}
