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

    @FindBy(how= How.XPATH, xpath = "(.//div[@class='clearfix lfr-pagination'])[1]/ul/li/a")
    private List<WebElement> topPaginationButtons;

    @FindBy(how= How.XPATH, xpath = "//span[@class='asset-entry-title']/a")
    private List<WebElement> titlesOfSearchResultBlocks;

    @FindBy(how= How.XPATH, xpath = ".//div[@class='alert alert-info']")
    private WebElement noResultsMessage;

    public boolean isDisplayedNoResultsMessageFor(String keyWord){
        noResultsMessage.getText().contains(keyWord);
        return noResultsMessage.getText().equals("No results were found that matched the keywords:"+keyWord);
    }

    public boolean isEmptySearchResults(){
        return titlesOfSearchResultBlocks.size()>0?true:false;
    }


}
