package TafPocLatest.Pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;

    @Inject
    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickSignInLink(){
        signInLink.click();
    }
}