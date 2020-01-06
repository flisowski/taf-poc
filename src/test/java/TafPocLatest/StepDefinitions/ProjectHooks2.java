//package TafPocLatest.StepDefinitions;
//
//import com.google.inject.Inject;
//import com.google.inject.name.Named;
//import cucumber.api.event.ConcurrentEventListener;
//import cucumber.api.event.EventHandler;
//import cucumber.api.event.EventPublisher;
//import cucumber.api.event.TestRunFinished;
//import cucumber.api.event.TestRunStarted;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.openqa.selenium.WebDriver;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProjectHooks2 implements ConcurrentEventListener {
//
//    @Inject
//    WebDriver driver;
//
//    @Inject
//    @Named("scope")
//    String scope;
//
//    // To quit the drivers and browsers at the end only.
//    private static List<WebDriver> storedDrivers = new ArrayList<>();
//
//    @After
//    public void quitBrowser() {
//        if (!scope.equals("reuse")) {
//            driver.quit();
//        }
//    }
//
//
//    @Override
//    public void setEventPublisher(EventPublisher eventPublisher) {
//        eventPublisher.registerHandlerFor(TestRunStarted.class, setup);
//        eventPublisher.registerHandlerFor(TestRunFinished.class, teardown);
//    }
//
//    private EventHandler<TestRunStarted> setup = event -> {
//        beforeAll();
//    };
//
//    private void beforeAll() {
//        System.out.println("in before all");
//    }
//
//    private EventHandler<TestRunFinished> teardown = event -> {
//        afterAll();
//    };
//
//    private void afterAll() {
//        for(WebDriver d: storedDrivers) {
//            d.quit();
//        }
//        System.out.println("in after all");
//    }
//
//    @Before
//    public void setup() {
//        if(scope.equals("reuse") && !storedDrivers.contains(driver)) {
//            storedDrivers.add(driver);
//        }
//    }
//
//}