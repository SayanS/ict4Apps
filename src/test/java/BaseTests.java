import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {
    private WebDriver webDriver;

    @BeforeClass
    @Parameters({"platform", "browser"})
    public void setUp(String platform, String browser) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setPlatform(Platform.extractFromSysProperty(platform));
        cap.setBrowserName(browser);
        URL url = new URL("http://192.168.10.61:4445/wd/hub");
        this.webDriver = new RemoteWebDriver(url, cap);
        getWebDriver().manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod(){
        webDriver.navigate().to("http://demo.ict4apps.com/welcome");
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    @AfterClass
    public void tearDown(){
        this.webDriver.close();
    }

    public WelcomePage getWelcomePage() {
        return new WelcomePage(getWebDriver());
    }

    public ProductsPage getProductsPage() {
        return new ProductsPage(getWebDriver());
    }

    public SpecialOfferPage getSpecialOfferPage() {
        return new SpecialOfferPage(getWebDriver());
    }

    public BlogsPage getBlogsPage() {
        return new BlogsPage(getWebDriver());
    }

    public ContactUsPage getContactUsPage() {
        return new ContactUsPage(getWebDriver());
    }

}
