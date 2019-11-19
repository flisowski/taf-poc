package Cucumber_Project.WebDriver;

import Cucumber_Project.Utilities.PropertiesLoader;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverFactory implements Provider<WebDriver> {

    @Inject
    @Named("browser.type")
    private String browserType;

    @Inject
    @Named("grid")
    private String grid;

    @Inject
    private PropertiesLoader propertiesLoader;

    public WebDriver get() {

        WebDriver webDriver = null;
        // CLI overrides application.properties
        if(System.getProperty("browser.type") != null) {
            browserType = System.getProperty("browser.type");
        }

        switch (browserType) {
        case "chrome":
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(this.getChromeOptions());
            break;
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver(this.getFirefoxOptions());
            break;
        case "remote":
            try {
                webDriver = new RemoteWebDriver(new URL(grid), getRemoteDriverCapabilities());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            break;
        default:
            webDriver = null;
            break;
        }
        return webDriver;
    }


    /**
     * implement a strategy to read the chrome capabilities
     * @return
     */
    private Capabilities getRemoteDriverCapabilities(){
        String remoteKeyPrefix = "driver.remote.";
        Properties properties = propertiesLoader.getProperties();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        properties.entrySet().forEach(entry -> {
            if(entry.getKey().toString().contains(remoteKeyPrefix)) {
                String key = entry.getKey().toString().split(remoteKeyPrefix)[1];
                desiredCapabilities.setCapability(key, entry.getValue());
            }
        });
        return desiredCapabilities;
    }


    /**
     * implement a strategy to read the chrome capabilities
     * @return
     */
    private ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        return chromeOptions;
    }

    /**
     * implement a strategy to read the IE capabilities
     * @return
     */
    private FirefoxOptions getFirefoxOptions(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return firefoxOptions;
    }

}