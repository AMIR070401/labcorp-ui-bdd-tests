package stepdefs;

import common.SharedDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CareerPage;
import pages.HomePage;
import pages.JobApplicationPage;

public class MyStepdefs {

    private static SharedDriver driver;
    HomePage homePage;
    CareerPage careerPage;
    JobApplicationPage jobApplicationPage;

    public MyStepdefs(SharedDriver driver) {
        MyStepdefs.driver = driver;
    }

    @After
    public void tearDown() {
        // Quit the driver after all scenarios
        driver.getDriver().quit();
    }

    @Given("^User navigates to application url$")
    public void userNavigatesToApplicationUrl() {
        driver.getDriver().get("https://www.labcorp.com/");
        driver.getDriver().manage().window().maximize();
    }

    @And("^User clicks on Careers link$")
    public void userClicksOnCareersLink() {
        homePage = new HomePage(driver);
        careerPage = homePage.clickOnCareerLink();
    }

    @When("^User searches for (.*) position$")
    public void userSearchesForJobTitlePosition(String jobTitle) {
        careerPage.searchJob(jobTitle);
    }

    @And("^User clicks on matching job position containing (.*)$")
    public void userClicksOnMatchingJobPosition(String jobTitle) {
        careerPage.clickMatchingJob(jobTitle);
    }

    @Then("^User verifies (.*) (.*) (.*) (.*) (.*) (.*) on detailed job page$")
    public void userVerifiesDetailsOnDetailedJobPage(String jobTitle, String location, String jobId, String remoteOption, String automationTool, String codingLanguage) {
        careerPage.verifyJobDetails(jobTitle, location, jobId, remoteOption, automationTool, codingLanguage);
    }

    @And("^User successfully applies to the job by pressing Apply Now button$")
    public void userSuccessfullyAppliesToJob() {
        jobApplicationPage = careerPage.clickApplyButton();
    }

    @And("^User verifies (.*) (.*) (.*) (.*) (.*) (.*) match with previous page$")
    public void userVerifiesDetailsMatchWithPreviousPage(String jobTitle, String location, String jobId, String remoteOption, String automationTool, String codingLanguage) {
        jobApplicationPage.verifyJobDetails(jobTitle, location, jobId, remoteOption, automationTool, codingLanguage);
    }
}

