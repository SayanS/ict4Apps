import models.MenuItemsUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HeaderMenuAfterScrollDown extends BasePage {
    private WebDriver webDriver;
    private  String MENU_ITEM_TEXT="//ul/li/a/span";

    public HeaderMenuAfterScrollDown(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @FindBy(how = How.XPATH, xpath = "(//nav[@id='navigation'])[2]")
    private WebElement headerMenuContainer;

    public List<String> getMenuItemsNames() {
        (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//nav[@id='navigation'])[2]"+MENU_ITEM_TEXT)));
        return getWebelementsText(webDriver.findElements(By.xpath("(//nav[@id='navigation'])[2]"+MENU_ITEM_TEXT)));
    }

    public String selectItemOfMenu(String itemName) {
        headerMenuContainer.findElement(By.xpath(".//span[.='" + itemName + "']/ancestor::a")).click();
        return webDriver.getCurrentUrl();
    }

    public String selectItemOfMenu(Integer itemNumber) {
        headerMenuContainer.findElement(By.xpath("(.//ul/li/a)["+itemNumber+"]")).click();
        return webDriver.getCurrentUrl();
    }

    public boolean isDisplayed() throws InterruptedException {
        (new WebDriverWait(webDriver, 1)).until(ExpectedConditions.visibilityOf(headerMenuContainer));
        return headerMenuContainer.isDisplayed();
    }

    public List<String> getMenuItemsUrls() {
        List<String> menuItemsUrls = new ArrayList<String>();

        for (int i=0; i<getMenuItemsNames().size();i++){
            menuItemsUrls.add(selectItemOfMenu(i+1));
            //webDriver.navigate().to("http://demo.ict4apps.com/products");
            webDriver.findElement(By.xpath("(.//li/a/span[.='Products'])[1]")).click();
            waitForElement(".//h3/span");
            scrollDownPage();
            waitVisabilityOf(headerMenuContainer);
        }

        return menuItemsUrls;
    }

}
