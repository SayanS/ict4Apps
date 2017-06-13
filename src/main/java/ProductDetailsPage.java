import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductDetailsPage extends BasePage{
private WebDriver webDriver;
    public ProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver=webDriver;
    }

    @FindBy(how= How.XPATH, xpath = ".//h1/span")
    private WebElement title;

    @FindBy(how= How.XPATH, xpath = ".//div[@class='info-product table-word-wrap']")
    private WebElement productDescription;

    public String getTitle(){
        return  title.getText();
    }

    public  String getProductDescription(){
        return  productDescription.getText();
    }

}
