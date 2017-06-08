import models.SpecialOffersCarouselContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import java.util.ArrayList;
import java.util.List;

public class WelcomePage extends BasePage {

    String VISIBLE_SPECIAL_OFFERS_CONTAINERS_TITLES = ".//div[@id='p_p_id_PRODUCT_PORTLET_WAR_ict4appsportlet_']//div[@class='slick-track']/div[@class='slick-slide slick-active']//h3/a";
    String VISIBLE_SPECIAL_OFFERS_CONTAINERS_DESCRIPTIONS = ".//div[@id='p_p_id_PRODUCT_PORTLET_WAR_ict4appsportlet_']//div[@class='slick-track']/div[@class='slick-slide slick-active']//div[@id='latestDesc']";
    String VISIBLE_SPECIAL_OFFERS_CONTAINERS_IMAGES = ".//div[@id='p_p_id_PRODUCT_PORTLET_WAR_ict4appsportlet_']//div[@class='slick-track']/div[@class='slick-slide slick-active']//img";

    private WebDriver webDriver;

    @FindBy(how = How.XPATH, xpath = "//ul[@role='menubar']/li/a")
    private List<WebElement> headerMenu;

    @FindBy(how = How.XPATH, xpath = ".//div[@id='p_p_id_PRODUCT_PORTLET_WAR_ict4appsportlet_']//div[@class='slick-track']/div")
    private List<WebElement> allSpecialOffersContainers;

    @FindBy(how = How.XPATH, xpath = ".//div[@id='p_p_id_PRODUCT_PORTLET_WAR_ict4appsportlet_']//div[@class='slick-track']//div[@class='product-item__img product-img-intro']/img")
    private List<WebElement> allImgSpecialOffersContainers;

    @FindBy(how = How.XPATH, xpath = ".//div[@id='p_p_id_PRODUCT_PORTLET_WAR_ict4appsportlet_']//div[@class='slick-track']//h3/a")
    private List<WebElement> allTitelesSpecialOffersContainers;

    @FindBy(how = How.XPATH, xpath = ".//div[@id='p_p_id_PRODUCT_PORTLET_WAR_ict4appsportlet_']//div[@class='slick-track']//div[@class='gallery-product__introtext']/div")
    private List<WebElement> allDescriptionsSpecialOffersContainers;

    @FindBy(how = How.XPATH, xpath = ".//section[@id='portlet_PRODUCT_PORTLET_WAR_ict4appsportlet']//button[@class='slick-prev']")
    private WebElement prevButtonSpecialOffersCarusel;

    @FindBy(how = How.XPATH, xpath = ".//section[@id='portlet_PRODUCT_PORTLET_WAR_ict4appsportlet']//button[@class='slick-next']")
    private WebElement nextButtonSpecialOffersCarusel;

    @FindBy(how=How.XPATH, xpath = ".//a[@class='login']")
    private WebElement signInButton;

    public SignInPage clickOnSignInButton(){
        signInButton.click();
        return new SignInPage(webDriver);
    }

    public WelcomePage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver=webDriver;
    }

    public List<String> getMenuItemNames() {
        List<String> menuItemNames = new ArrayList<String>();
        for (WebElement itemName : headerMenu) {
            menuItemNames.add(itemName.getText());
        }
        return menuItemNames;
    }

    public BasePage selectItemHeaderMenu(String itemName) {
        for (WebElement we : headerMenu) {
            if (we.getText().equals(itemName)) {
                we.click();
                return new BasePage(webDriver);
            }
        }
        return null;
    }


    public void checkCaruselAction() {

        String[] allTitelesSpecialOffers = getWebelementsText(allTitelesSpecialOffersContainers);
        String[] allDescriptionsSpecialOffers = getWebelementsText(allDescriptionsSpecialOffersContainers);
        String[] allImagesSpecialOffers = getWebelementsParameterValue(allImgSpecialOffersContainers, "data-lazy");

    }

    public void clickOnNextSpecialOfferCarusel() {
        nextButtonSpecialOffersCarusel.click();
    }

    public SpecialOffersCarouselContainer[] getVisibleSpecialOfferCarouselContainers() throws InterruptedException {
        int visibleConteiners = 3;
        SpecialOffersCarouselContainer[] visibleContainers = new SpecialOffersCarouselContainer[visibleConteiners];
        for (int i = 0; i < visibleConteiners; i++) {
            visibleContainers[i] = new SpecialOffersCarouselContainer();
            moveTo(webDriver.findElement(By.xpath("(" + VISIBLE_SPECIAL_OFFERS_CONTAINERS_IMAGES + ")[" + (i + 1) + "]")));
            visibleContainers[i].imageUrl = webDriver.findElement(By.xpath("(" + VISIBLE_SPECIAL_OFFERS_CONTAINERS_IMAGES + ")[" + (i + 1) + "]")).getAttribute("src").replace("http://demo.ict4apps.com", "");
            visibleContainers[i].description = webDriver.findElement(By.xpath("(" + VISIBLE_SPECIAL_OFFERS_CONTAINERS_DESCRIPTIONS + ")[" + (i + 1) + "]")).getText();
            visibleContainers[i].title = webDriver.findElement(By.xpath("(" + VISIBLE_SPECIAL_OFFERS_CONTAINERS_TITLES + ")[" + (i + 1) + "]")).getText();
        }
        return visibleContainers;
    }

    public SpecialOfferPage clickOnTitleOfSpecialOfferCarousel(int i) {
        moveTo(find("(" + VISIBLE_SPECIAL_OFFERS_CONTAINERS_IMAGES + ")[" + (i + 1) + "]"));
        find("(" + VISIBLE_SPECIAL_OFFERS_CONTAINERS_TITLES + ")[" + (i + 1) + "]").click();
        return new SpecialOfferPage(webDriver);
    }

    public SpecialOfferPage clickOnTitleOfSpecialOfferCarousel(String name) {
        boolean flag = true;
        for (int j = 1; j <= allImgSpecialOffersContainers.size() / 3; j++) {
            for (int i = 1; i <= findAll(VISIBLE_SPECIAL_OFFERS_CONTAINERS_IMAGES).size(); i++) {
                moveTo(find("(" + VISIBLE_SPECIAL_OFFERS_CONTAINERS_IMAGES + ")[" + i + "]"));
                if (find("(" + VISIBLE_SPECIAL_OFFERS_CONTAINERS_TITLES + ")[" + i + "]").getText().equals(name)) {
                    find("(" + VISIBLE_SPECIAL_OFFERS_CONTAINERS_TITLES + ")[" + i + "]").click();
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                clickOnNextSpecialOfferCarusel();
            } else {
                break;
            }
        }
        return new SpecialOfferPage(webDriver);
    }


}
