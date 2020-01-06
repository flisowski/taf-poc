package TafPocLatest.StepDefinitions;

import TafPocLatest.WebDriver.DriverFactory;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;

public class ProjectHooks {

    @Inject
    WebDriver driver;

    @Inject
    DriverFactory driverFactory;

    @Inject
    @Named("scope")
    String scope;

    // To quit the drivers and browsers at the end only.
    private static List<WebDriver> storedDrivers = new ArrayList<>();

    @Before
    public void setup() {
        if(scope.equals("reuse")) {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    driver.quit();
                }
            });
        }
    }

//    @Before
//    public void setup() {
//        if ( ((RemoteWebDriver) driver).getSessionId() == null ) {
//            driver = driverFactory.get();
//        }
//        if(scope.equals("reuse") && !storedDrivers.contains(driver)) {
//            storedDrivers.add(driver);
//            Runtime.getRuntime().addShutdownHook(new Thread() {
//                @Override
//                public void run() {
//                    storedDrivers.remove(driver);
//                    System.out.println("QUITTT");
//                    driver.quit();
//                }
//            });
//        }
//    }


    @After
    public void quitBrowser(Scenario scenario) {
        System.out.println("kek");
        if (!scope.equals("reuse")) {
            driver.quit();
        }
    }

}