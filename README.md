Basic walkthrough on the designed framework:

I have used coding language Java with Selenium for UI automation
Framework which I have used is BDD using cucumber and gherkin language
Feature files are written using plain English language under given path: "src/test/resources/Features"
Step definitions are written under given path: "src/test/java/stepdefs"
Runner class is defined under given path: "src/test/java/RunCukesTest.java"
I have used the Page Object Model design pattern
Each web page has a corresponding class that contains its elements and methods
These classes are stored in a separate Pages package under given path: "src/test/java/pages"
Commonly used methods are defined in "src/test/java/pages/BasePage.java"
There is config.properties file which used configuration information such as Browser to be used, application url, etc
Driver initialization for the provided browser is done at runtime in java file "src/test/java/common/SharedDriver.java"
At the moment support is provided for Chrome, Firefox and Edge browser
Logging is done through Apache Log4j logger
TestNG is used for assertions
Maven is used for Dependency and Build management
pom.xml file contains all necessary dependencies
Reporting is done via Cucumber Reports
