package TafPocLatest.Guice;

import TafPocLatest.Utilities.PropertiesLoader;
import TafPocLatest.WebDriver.DriverFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Scope;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;


public class ProjectModule extends AbstractModule {

    @Override
    protected void configure() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();

        if( propertiesLoader.isScopeReuse() ) {
            bind(WebDriver.class).toProvider(DriverFactory.class).in(Scopes.SINGLETON);
        } else {
            bind(WebDriver.class).toProvider(DriverFactory.class).in(ScenarioScoped.class);
        }

        //        Alternative
//                bind(DriverManager.class).toProvider(DriverFactory.class).in(Scopes.SINGLETON);
        //        another
        //        WebDriver driver = DriverManagerFactory.getManager("chrome").getDriver();
        //        bind(WebDriver.class).to(driver.getClass()).in(ScenarioScoped.class);

        Names.bindProperties(binder(), propertiesLoader.getProperties());
    }

//        @Provides
//        public WebDriver getDriver(DriverManager driverManager) {
//            return driverManager.getDriver();
//        }

}