import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.lang.reflect.Array;
import java.util.List;

public class SignInPage extends BasePage {
    private WebDriver webDriver;

    public SignInPage(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }
    @FindBy(how= How.XPATH, xpath =".//ul[@class='taglib-icon-list unstyled']/li/a" )
    private List<WebElement> signInMenu;

    @FindBy(how=How.XPATH, xpath = ".//div[@class='alert alert-success']")
    private WebElement successRegistrationMessage;

    @FindBy(how= How.XPATH, xpath =".//a/span[contains(text(), 'Create Account')]" )
    private WebElement createAccountButton;

    public String getSuccessRegistrationMessage(){
        return successRegistrationMessage.getText();
    }

    public CreateAccountPage clickOnCreateAccount(){
        createAccountButton.click();
        return new CreateAccountPage(webDriver);
    }
}
