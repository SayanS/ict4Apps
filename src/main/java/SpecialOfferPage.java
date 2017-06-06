import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SpecialOfferPage extends BasePage{

    public SpecialOfferPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how= How.XPATH, xpath=".//h1/span")
    private WebElement title;

    public String getTitle(){
        waitVisabilityOf(title);
        return title.getText();
    }

}