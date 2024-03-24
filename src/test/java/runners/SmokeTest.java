package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@smoke",
        features = {"src/test/resources/features/SmokeTest.feature"},
        glue = {"step/definitions"},
        plugin = {"pretty"}, monochrome = true)
public class SmokeTest extends AbstractTestNGCucumberTests {

}
