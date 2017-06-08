import models.SpecialOffersCarouselContainer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SmokeTests extends BaseTests {
    WelcomePage welcomePage;
    ProductsPage productsPage;
    SpecialOfferPage specialOfferPage;
    BasePage basePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;


    @Test
    public void checkInabilityToRegisterWithIncorrectVerificationText(){
        signInPage=openWelcomePage().clickOnSignInButton();
        createAccountPage=signInPage.clickOnCreateAccount().enterFirstName("Petro").enterScreenName("Poroh").enterEmail("peter@mail.ru")
                .enterBirthday("12/12/1975").enterGender("Male.").enterVerificationText("9999");
        createAccountPage.clickOnSaveButton();
        Assert.assertEquals(createAccountPage.getFailureMessage(),"Your request failed to complete.");
        Assert.assertEquals(createAccountPage.getErrorMessage(),"Text verification failed.");
    }

//    @Test
//    public void checkTitleLinkOfSpecialOfferCarousel(){
//        String titleName="HEN WITH GREEN APPLES";
//        welcomePage=openWelcomePage();
//        Assert.assertEquals(welcomePage.clickOnTitleOfSpecialOfferCarousel(titleName).getTitle(),titleName);
//    }
//
//    @Test
//    public void checkNextFunctionOfSpecialOfferCarusel() throws InterruptedException {
//        SpecialOffersCarouselContainer[] VisibleSpecialOffersCarouselContainersBeforeClick;
//        welcomePage=openWelcomePage();
//        VisibleSpecialOffersCarouselContainersBeforeClick=welcomePage.getVisibleSpecialOfferCarouselContainers();
//        welcomePage.clickOnNextSpecialOfferCarusel();
//        Assert.assertNotEquals(welcomePage.getVisibleSpecialOfferCarouselContainers(),VisibleSpecialOffersCarouselContainersBeforeClick, "The arrays shouldn't be equal");
//    }
//
//    @Test
//    public void maxDepthMenuItemOpensAppropriatePage() throws InterruptedException {
//        welcomePage = openWelcomePage();
//        welcomePage.selectItemHeaderMenu("PRODUCTS");
//        productsPage = getProductsPage();
//        Assert.assertEquals(productsPage.clickOnFirstMaxDepthItemsMenu(), productsPage.getTitle());
//    }
//
//    @Test
//    public void checkHeaderMenuNames() {
//        String[] expectedMenuItemNames = {"WELCOME", "PRODUCTS", "SPECIAL OFFERS", "BLOGS", "CONTACT US"};
//        welcomePage = openWelcomePage();
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
//        welcomePage = openWelcomePage();
//        welcomePage.selectItemHeaderMenu(data[0]);
//        Assert.assertEquals(data[1], getCurrentUrl());
//        Assert.assertEquals(data[2], welcomePage.getLastBreadCrumb());
//    }


}
