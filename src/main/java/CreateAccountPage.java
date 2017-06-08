import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateAccountPage extends BasePage{
    private WebDriver webDriver;
    public CreateAccountPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver=webDriver;
    }

    private String FAILURE_MESSAGE="(//div[@class='alert alert-error'])[1]";
    private String ERROR_MESSAGE="(//div[@class='alert alert-error'])[2]";

    @FindBy(how= How.XPATH, xpath = ".//label[contains(text(),'First Name')]/following-sibling::input")
    private WebElement firstName;

    @FindBy(how= How.XPATH, xpath = ".//label[contains(text(),'Screen Name')]/following-sibling::input")
    private WebElement screenName;

    @FindBy(how= How.XPATH, xpath = ".//label[contains(text(),'Email Address')]/following-sibling::input")
    private WebElement emailAddress;

    @FindBy(how= How.XPATH, xpath = ".//label[contains(text(),'Birthday')]/following-sibling::div/span/input[1]")
    private WebElement birthday;

    @FindBy(how= How.XPATH, xpath = ".//label[contains(text(),'Gender')]/following-sibling::select")
    private WebElement gender;

    @FindBy(how= How.XPATH, xpath = ".//label[contains(text(),'Text Verification')]/following-sibling::input")
    private WebElement verificationText;

    @FindBy(how=How.XPATH, xpath = ".//button[@type='submit']")
    private WebElement saveButton;

    public SignInPage clickOnSaveButton(){
        saveButton.click();
        return new SignInPage(webDriver);
    }

    public CreateAccountPage enterFirstName(String firstName){
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        return this;
    }

    public CreateAccountPage enterScreenName(String screenName){
        this.screenName.clear();
        this.screenName.sendKeys(screenName);
        return this;
    }

    public CreateAccountPage enterEmail(String email){
        this.emailAddress.clear();
        this.emailAddress.sendKeys(email);
        return this;
    }

    public CreateAccountPage enterBirthday(String birthday){
        this.birthday.clear();
        this.birthday.sendKeys(birthday);
        return this;
    }

    public CreateAccountPage enterGender(String gender){
        this.gender.click();
        this.gender.findElement(By.xpath(".//option[contains(text(),'"+gender+"')]")).click();
        return this;
    }

    public CreateAccountPage enterVerificationText(String verificationText){
        this.verificationText.clear();
        this.verificationText.sendKeys(verificationText);
        return this;
    }


    public String getFailureMessage() {
        return find(FAILURE_MESSAGE).getText();
    }

    public String getErrorMessage() {
        return find(ERROR_MESSAGE).getText();
    }
}
