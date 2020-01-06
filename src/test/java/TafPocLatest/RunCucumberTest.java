package TafPocLatest;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/Features",
        glue= "TafPocLatest/StepDefinitions",
        plugin = {"pretty"},
        monochrome = true)
public class RunCucumberTest {
}
