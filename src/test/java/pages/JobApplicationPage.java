package pages;

import common.SharedDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class JobApplicationPage extends BasePage{
    protected final SharedDriver driver;
    private final static String jobTitleXpath = "//*[text()='Start Your Application']/following-sibling::h3";

    /**
     * * Description: Constructor to initialize driver
     * * Author: AMIR AHMAD
     */
    public JobApplicationPage(SharedDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * * Description: Method to verify job details on Job Application page
     * * Author: AMIR AHMAD
     */
    public JobApplicationPage verifyJobDetails(String jobTitle, String location, String jobId, String remoteOption, String automationTool, String codingLanguage) {
        String jobTitleText = getText(By.xpath(jobTitleXpath));
        Assert.assertEquals(jobTitleText, jobTitle, "Job title does not match");
        return this;
    }
}
