Basic walkthrough on the designed framework:

1. I have used coding language Java with Selenium for UI automation.
2. Framework which I have used is BDD using cucumber and gherkin language.
3. Feature files are written using plain English language under given path: "src/test/resources/Features".
4. Step definitions are written under given path: "src/test/java/stepdefs".
5. Runner class is defined under given path: "src/test/java/RunCukesTest.java".
6. I have used the Page Object Model design pattern.
7. Each web page has a corresponding class that contains its elements and methods.
8. These classes are stored in a separate Pages package under given path: "src/test/java/pages".
9. Commonly used methods are defined in "src/test/java/pages/BasePage.java".
10. There is config.properties file which used configuration information such as Browser to be used, application url, etc.
11. Driver initialization for the provided browser is done at runtime in java file "src/test/java/common/SharedDriver.java".
12. At the moment support is provided for Chrome, Firefox and Edge browser.
13. Logging is done through Apache Log4j logger.
14. TestNG is used for assertions.
15. Maven is used for Dependency and Build management.
16. pom.xml file contains all necessary dependencies.
17. Reporting is done via Cucumber Reports.
