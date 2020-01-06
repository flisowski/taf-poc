package TafPocLatest.Guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;
import cucumber.runtime.java.guice.impl.SequentialScenarioScope;

public class GuiceInjector implements InjectorSource {
    @Override public Injector getInjector() {
        return Guice.createInjector(
                CucumberModules.createScenarioModule(new SequentialScenarioScope()),
                new TafPocLatest.Guice.ProjectModule()
        );
    }
}