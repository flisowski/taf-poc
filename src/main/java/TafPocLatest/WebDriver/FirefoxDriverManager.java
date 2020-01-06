package TafPocLatest.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();
        return driver = new FirefoxDriver();
    }
}