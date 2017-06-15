import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class BasePage {
    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    private WebDriver webDriver;
/*
    WebDriver getWebDriver() {
        return this.webDriver;
    }
*/

    public WebElement waitForElement(String xpath) {
        return (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }


    public String getLastBreadCrumb() {
        if (webDriver.getCurrentUrl().contains("welcome")) {
            return "";
        }
        return waitForElement("//ul[@aria-label='Breadcrumb']/li[last()]").getText();
        //return getWebDriver().findElement(By.xpath("//ul[@aria-label='Breadcrumb']/li[last()]")).getText();
    }


    public WebElement find(String xpath) {
        return (new WebDriverWait(webDriver, 4)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public List<WebElement> findAll(String xpath) {
        (new WebDriverWait(webDriver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(" + xpath + ")[1]")));
        return webDriver.findElements(By.xpath(xpath));
    }

    public List<String> getWebelementsText(List<WebElement> webElements) {
        List<String> webelementsText = new ArrayList<>();
        for (WebElement webElement:webElements) {
            webelementsText.add(webElement.getText());
        }
        return webelementsText;
    }

    public List<String> getWebelementsParameterValue(List<WebElement> webElements, String parameterName) {
        List<String> webElementsParameterValue = new ArrayList<String>();
        for (WebElement webElement:webElements) {
            webElementsParameterValue.add(webElement.getAttribute(parameterName));
        }
        return webElementsParameterValue;
    }

    public void moveTo(WebElement webElement) {
        Actions action = new Actions(webDriver);
        action.moveToElement(webElement).perform();
    }

    public WebElement waitVisabilityOf(WebElement webElement) {
        return (new WebDriverWait(webDriver, 60)).until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement getWebElementFromListByVisibleText(List<WebElement> webElements, String text){
        for(WebElement webElement:webElements){
            if(webElement.getText().equals(text)){
                return webElement;
            }
        }
        return null;
    }

    public HeaderMenuAfterScrollDown scrollDownPage(){
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,250);");
        return new HeaderMenuAfterScrollDown(webDriver);
    }


}
