package Cucumber_Project.Guice;

import Cucumber_Project.Utilities.PropertiesLoader;
import Cucumber_Project.WebDriver.DriverFactory;
import com.google.inject.AbstractModule;
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

        Names.bindProperties(binder(), propertiesLoader.getProperties());
    }

}