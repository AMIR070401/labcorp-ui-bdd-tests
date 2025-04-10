@SearchJob
Feature: Job Application

  Scenario Outline: As a user I want to test job application functionality
    Given User navigates to application url
    And User clicks on Careers link
    When User searches for <job_title> position
    And User clicks on matching job position containing <job_title>
    Then User verifies <job_title> <location> <job_id> <remote_option> <automation_tool> <coding_language> on detailed job page
    And User successfully applies to the job by pressing Apply Now button
    And User verifies <job_title> <location> <job_id> <remote_option> <automation_tool> <coding_language> match with previous page

    Examples:
      | job_title           | location  | job_id | remote_option | automation_tool | coding_language |
      | Automation Engineer | Bangalore | 257322 | No            | Selenium        | Java            |
