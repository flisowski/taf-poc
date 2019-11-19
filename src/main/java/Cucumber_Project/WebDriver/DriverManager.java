package Cucumber_Project.WebDriver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;
    protected abstract WebDriver createDriver();

    public WebDriver getDriver() {
        if (driver == null) {
            this.createDriver();
        }
        return driver;
    }
}