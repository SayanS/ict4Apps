import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage{
    private WebDriver webDriver;
    public ContactUsPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver=webDriver;
    }
}
