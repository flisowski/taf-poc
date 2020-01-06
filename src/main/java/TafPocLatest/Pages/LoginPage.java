package TafPocLatest.Pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "site-search-text")
    private WebElement search;

    @FindBy(id = "search-submit")
    private WebElement submitButton;

    @Inject
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void typeSearch(String text){
        search.clear();
        search.sendKeys(text);
        submitButton.click();
    }

    public void setEmail(String text){
        email.clear();
        email.sendKeys(text);
    }

    public void setPassword(String text){
        password.clear();
        password.sendKeys(text);
    }

    public void clickSubmit(){
        submitButton.click();
    }
}