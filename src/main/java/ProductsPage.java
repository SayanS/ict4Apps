import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    private WebDriver webDriver;

    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver=webDriver;
    }

    String CATALOG_MENU_FIRST_LEVEL = ".//ul[@class='jqtree_common jqtree-tree']/li";

    @FindBy(how = How.XPATH, xpath = ".//ul[@class='jqtree_common jqtree-tree']")
    private WebElement productTree;

    @FindBy(how = How.XPATH, xpath = "//h3[@class='header-title']/span")
    private WebElement title;

    @FindBy(how = How.XPATH, xpath = ".//input[@name='_3_keywords']")
    private WebElement searchField;

    @FindBy(how = How.XPATH, xpath = ".//button[@type='submit']")
    private WebElement searchButton;

    public SearchResultsPage clickOnSearchButton(){
        searchButton.click();
        return new SearchResultsPage(webDriver);
    }

    public void enterKeyWordIntoSearchField(String keyWord){
        searchField.clear();
        searchField.sendKeys(keyWord);
    }


    public String getTitle() {
        return waitForElement("//h3[@class='header-title']/span").getText();
    }

    public ProductsPage expandAllCategory() throws InterruptedException {
        List<WebElement> currentLevelTree = new ArrayList<WebElement>();
        while (true) {
            currentLevelTree = productTree.findElements(By.xpath(".//a[.='►']"));
            if (currentLevelTree.size() == 0) break;
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", currentLevelTree.get(0));
        }
        return new ProductsPage(webDriver);
    }

    public List<WebElement> getMaxLevelProducts() throws InterruptedException {
        String xpathCurrentLevel = CATALOG_MENU_FIRST_LEVEL;
        List<WebElement> maxLevelProducts = new ArrayList<WebElement>();
        while (true) {
            maxLevelProducts =webDriver.findElements(By.xpath(xpathCurrentLevel + "/ul/li"));
            if (maxLevelProducts.size() != 0) {
                xpathCurrentLevel = xpathCurrentLevel + "/ul/li";
            } else break;
        }
        maxLevelProducts = webDriver.findElements(By.xpath(xpathCurrentLevel + "/div/span"));
        return maxLevelProducts;
    }


    public String clickOnFirstMaxDepthItemsMenu() throws InterruptedException {
        List<WebElement> maxLevelProducts = new ArrayList<WebElement>();
        String productName;
        expandAllCategory();
        maxLevelProducts = getMaxLevelProducts();
        productName = getMaxLevelProducts().get(0).getText();
        maxLevelProducts.get(0).click();
        return productName;
    }


}
//        Response resp=get("http://demo.ict4apps.com/products?p_p_id=CATEGORY_PORTLET_WAR_ict4appsportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_resource_id=getChildren&p_p_cacheability=cacheLevelPage&p_p_col_id=_118_INSTANCE_VKrz3jsdAQaU__column-1&p_p_col_count=1");
//        JSONArray jsonResponse = new JSONArray(resp.asString());
//        jsonResponse.toList().get(3);
//        ((JSONArray)jsonResponse.getJSONObject(3).get("children")).toList().get(1);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ProductsCategoryTree productsCategoryTree = restTemplate.getForObject("http://demo.ict4apps.com/products?p_p_id=CATEGORY_PORTLET_WAR_ict4appsportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_resource_id=getChildren&p_p_cacheability=cacheLevelPage&p_p_col_id=_118_INSTANCE_VKrz3jsdAQaU__column-1&p_p_col_count=1",
//                                                      models.ProductsCategoryTree.class);