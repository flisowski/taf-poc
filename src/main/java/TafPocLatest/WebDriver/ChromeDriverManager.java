package TafPocLatest.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        return driver = new ChromeDriver();
    }
}