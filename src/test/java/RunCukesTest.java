import io.cucumber.testng.*;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "stepdefs",
        tags = "@SearchJob"
)
public class RunCukesTest extends AbstractTestNGCucumberTests {

}

