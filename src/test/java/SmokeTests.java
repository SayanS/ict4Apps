import models.SpecialOffersCarouselContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SmokeTests extends BaseTests{
    WelcomePage welcomePage;
    ProductsPage productsPage;

    @Test
    public void checkNextFunctionOfSpecialOfferCarusel() throws InterruptedException {
        SpecialOffersCarouselContainer[] VisibleSpecialOffersCarouselContainersBeforeClick;
        welcomePage=getWelcomePage();
        VisibleSpecialOffersCarouselContainersBeforeClick=welcomePage.getVisibleSpecialOfferCarouselContainers();
        welcomePage.clickOnNextSpecialOfferCarusel();
        Assert.assertNotEquals(welcomePage.getVisibleSpecialOfferCarouselContainers(),VisibleSpecialOffersCarouselContainersBeforeClick, "The arrays shouldn't be equal");
    }

//    @Test
//    public void maxDepthMenuItemOpensAppropriatePage() throws InterruptedException {
//        welcomePage=getWelcomePage();
//        welcomePage.selectItemHeaderMenu("PRODUCTS");
//        productsPage=getProductsPage();
//        Assert.assertEquals(productsPage.clickOnFirstMaxDepthItemsMenu(),productsPage.getTitle());
//    }
//
//    @Test
//    public void checkHeaderMenuNames() {
//        String[] expectedMenuItemNames = {"WELCOME", "PRODUCTS", "SPECIAL OFFERS", "BLOGS", "CONTACT US"};
//        welcomePage = getWelcomePage();
//        Assert.assertEquals(welcomePage.getMenuItemNames().toArray(), expectedMenuItemNames);
//    }
//
//    @DataProvider(name = "headerMenuLinkRelatedData")
//    public Object[][] createHeaderMenuLinkRelatedData() {
//        return new Object[][]{
//                {"WELCOME", "http://demo.ict4apps.com/welcome", ""},
//                {"PRODUCTS", "http://demo.ict4apps.com/products", "Products"},
//                {"SPECIAL OFFERS", "http://demo.ict4apps.com/special-offers", "Special Offers"},
//                {"BLOGS", "http://demo.ict4apps.com/blogs", "Blogs"},
//                {"CONTACT US", "http://demo.ict4apps.com/contact-us", "Contact Us"}};
//    }
//
//    @Test(dataProvider = "headerMenuLinkRelatedData")
//    public void checkHeaderMenuLinks(String[] data) throws InterruptedException {
//        welcomePage = getWelcomePage();
//        welcomePage.selectItemHeaderMenu(data[0]);
//        Assert.assertEquals(data[1], getCurrentUrl());
//        Assert.assertEquals(data[2], getLastBreadCrumb());
//    }


}
