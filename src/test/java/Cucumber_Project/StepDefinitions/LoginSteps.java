package Cucumber_Project.StepDefinitions;

import java.util.concurrent.TimeUnit;
import Cucumber_Project.Pages.AccountPage;
import Cucumber_Project.Pages.HomePage;
import Cucumber_Project.Pages.LoginPage;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    @Inject
    public WebDriver driver;
    @Inject
    public HomePage homePage;
    @Inject
    public LoginPage loginPage;
    @Inject
    public AccountPage accountPage;

    @Inject
    @Named("website.url")
    public String websiteUrl;

    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(websiteUrl);
    }

    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
        homePage.clickSignInLink();
    }

    @When("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {
        loginPage.setEmail("blog.cucumber@gmail.com");
        loginPage.setPassword("Cucumber@blog");
        loginPage.clickSubmit();
    }

    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
        String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
        String actual = accountPage.getAccountInfoText();
        Assert.assertEquals(exp_message, actual);
    }

    @When("^user searches for shoes in the search bar$")
    public void user_searches() throws Throwable {
        driver.findElement(By.id("search_query_top")).sendKeys("shoes");
        driver.findElement(By.name("submit_search")).click();
    }

    @Then("^user is taken to the search results$")
    public void taken_to_search_results() throws Throwable {
        String exp_message = "7 results have been found.";
        String actual = driver.findElement(By.className("heading-counter")).getText();
        Assert.assertEquals(exp_message, actual);
        driver.quit();
    }

    @When("^user enters incorrect username and Password$")
    public void user_enters_incorrect_username_and_Password() throws Throwable {
        driver.findElement(By.id("email")).sendKeys("invalid@EMAIL");
        driver.findElement(By.id("passwd")).sendKeys("Cucumber@blog");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Then("^error message is displayed$")
    public void error_message_is_displayed() throws Throwable {
        String exp_message = "There is 1 error\n"
                + "Invalid email address.";
        String actual = driver.findElement(By.className("alert")).getText();
        Assert.assertEquals(exp_message, actual);
        driver.quit();
    }

}