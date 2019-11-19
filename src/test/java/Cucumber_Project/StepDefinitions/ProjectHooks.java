package Cucumber_Project.StepDefinitions;

import com.cucumber.listener.Reporter;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import cucumber.api.java.After;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class ProjectHooks {

    @Inject
    WebDriver driver;

    @Inject
    @Named("scope")
    String scope;


    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));
    }

    @After
    public void quitBrowser() {
        if (!scope.equals("reuse")) driver.quit();

    }
}