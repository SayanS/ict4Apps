import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchResultsPage extends BasePage {
    private WebDriver webDriver;
    public SearchResultsPage(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }

    @FindBy(how= How.XPATH, xpath = ".//*[@name='_3_keywords']")
    private WebElement searchField;

    @FindBy(how= How.XPATH, xpath = ".//*[@type='submit']")
    private WebElement searchButton;

    @FindBy(how= How.XPATH, xpath = ".//button[@id='_3_clearSearch']")
    private WebElement clearSearchField;

    @FindBy(how= How.XPATH, xpath = ".//select[@title='selected_scope']")
    private WebElement selectSearchCategory;

    @FindBy(how= How.XPATH, xpath = "(.//div[@class='clearfix lfr-pagination'])[1]/small")
    private WebElement topLabelShowing;

    @FindBy(how= How.XPATH, xpath = "(.//div[@class='clearfix lfr-pagination'])[1]/ul/li/a[contains(text(),'More')]")
    private WebElement moreButtonOfTopPagination;

    @FindBy(how= How.XPATH, xpath = "(.//div[@class='clearfix lfr-pagination'])[1]/ul/li/a[contains(text(),'First')]")
    private WebElement firstButtonOfTopPagination;

    @FindBy(how= How.XPATH, xpath = "(.//div[@class='clearfix lfr-pagination'])[1]/ul/li/a[contains(text(),'Previous')]")
    private WebElement previousButtonOfTopPagination;

    @FindBy(how= How.XPATH, xpath = ".//tbody[@class='table-data']")
    private WebElement searchResultContainer;

    @FindBy(how= How.XPATH, xpath = ".//div[@class='alert alert-info']")
    private WebElement noResultsMessage;

    public boolean isDisplayedNoResultsMessageFor(String keyWord){
        noResultsMessage.getText().contains(keyWord);
        return noResultsMessage.getText().equals("No results were found that matched the keywords:"+keyWord);
    }

    public String getSearchFieldText() {
        return searchField.getAttribute("value");
    }

    public void enterTextIntoSearchField(String searchText){
        searchField.sendKeys(searchText);
    }

    public String getCurrentSearchCategory() {
        return webDriver.findElement(By.xpath(".//select[@title='selected_scope']/option[@selected='']")).getText();
    }
    
    public List<String> getAllSearchCategoryFromCurrentPage(){
        return getWebelementsText(searchResultContainer.findElements(By.xpath("//span[@class='asset-entry-type']")));
    }

    public void navigateToLastSearchResultsPage() throws InterruptedException {
        try {
            while (moreButtonOfTopPagination.getCssValue("color").equals("rgba(223, 102, 12, 1)")) {
                moreButtonOfTopPagination.click();
            }
        }catch(Exception e){

        }
    }

    public boolean isLastContainerContainsCategory(String categoryName) throws InterruptedException {
        navigateToLastSearchResultsPage();
        return searchResultContainer.findElement(By.xpath("(//span[@class='asset-entry-type'])[last()]")).getText().equals(categoryName);
    }

    public boolean isFirstContainerContainsCategory(String categoryName) {
        return searchResultContainer.findElement(By.xpath("(//span[@class='asset-entry-type'])[1]")).getText().equals(categoryName);
    }

    public ProductDetailsPage clickOnTitlteOfFirstConteinerOfSearchResults(){
        searchResultContainer.findElement(By.xpath("(//div[@class='span11']/span/a)[1]")).click();
        return new ProductDetailsPage(webDriver);
    }


}
