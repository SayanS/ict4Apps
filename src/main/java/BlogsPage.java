import org.openqa.selenium.WebDriver;

public class BlogsPage extends BasePage{
    private WebDriver webDriver;
    public BlogsPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver=webDriver;
    }
}
