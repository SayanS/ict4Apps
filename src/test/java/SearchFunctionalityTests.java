import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 13.06.17.
 */
public class SearchFunctionalityTests extends BaseTests{
    WelcomePage welcomePage;
    ProductsPage productsPage;
    SearchResultsPage searchResultsPage;
    ProductDetailsPage productDetailsPage;

    @Test
    public void checkSearchFunctionFromProductsPage() throws InterruptedException {
        String keyWord="a";
        productsPage=openProductsPage();
        productsPage.enterKeyWordIntoSearchField(keyWord);
        searchResultsPage=productsPage.clickOnSearchButton();
        Assert.assertEquals(searchResultsPage.getSearchFieldText(), keyWord,"Search key should be"+keyWord);
        Assert.assertEquals(searchResultsPage.getCurrentSearchCategory(),"Products","Current Search category should be: Products");
        Assert.assertTrue(searchResultsPage.isFirstContainerContainsCategory("Product"));
        Assert.assertTrue(searchResultsPage.isLastContainerContainsCategory("Product"));
        productDetailsPage=searchResultsPage.clickOnTitlteOfFirstConteinerOfSearchResults();
        Assert.assertTrue((productDetailsPage.getTitle().contains(keyWord) || productDetailsPage.getProductDescription().contains(keyWord)),"Title or Product description isn't contained: "+keyWord);
    }

}
