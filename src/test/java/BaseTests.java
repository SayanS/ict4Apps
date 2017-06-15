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
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        this.webDriver.close();
    }

    public WelcomePage openWelcomePage() {
        webDriver.navigate().to("http://demo.ict4apps.com");
        return new WelcomePage(webDriver);
    }

    public ProductsPage openProductsPage() {
        webDriver.navigate().to("http://demo.ict4apps.com/products");
        return new ProductsPage(webDriver);
    }

    public ProductsPage getProductsPage() {
        return new ProductsPage(webDriver);
    }

    public SpecialOfferPage openSpecialOfferPage() {
        webDriver.navigate().to("http://demo.ict4apps.com/special-offers");
        return new SpecialOfferPage(webDriver);
    }

    public BlogsPage openBlogsPage() {
        webDriver.navigate().to("http://demo.ict4apps.com/blogs");
        return new BlogsPage(webDriver);
    }

    public ContactUsPage openContactUsPage() {
        webDriver.navigate().to("http://demo.ict4apps.com/contact-us");
        return new ContactUsPage(webDriver);
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }


}
