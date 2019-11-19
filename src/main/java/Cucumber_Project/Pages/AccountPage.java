package Cucumber_Project.Pages;


import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountPage extends BasePage {


    @FindBy(css = ".info-account")
    private WebElement accountInfo;

    @Inject
    public AccountPage(WebDriver driver){
        super(driver);
    }


    public String getAccountInfoText(){
        return accountInfo.getText();
    }
}