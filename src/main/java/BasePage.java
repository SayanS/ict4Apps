import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasePage {
    public BasePage(WebDriver webDriver){
        this.webDriver=webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    private WebDriver webDriver;

     WebDriver getWebDriver(){
        return this.webDriver;
    }



    public WebElement waitForElement(String xpath){
        return (new WebDriverWait(getWebDriver(),10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }



    public String getLastBreadCrumb(){
        if(webDriver.getCurrentUrl().contains("welcome")){
            return "";
        }
        return waitForElement("//ul[@aria-label='Breadcrumb']/li[last()]").getText();
        //return getWebDriver().findElement(By.xpath("//ul[@aria-label='Breadcrumb']/li[last()]")).getText();
    }


    public WebElement find(String xpath) {
        return (new WebDriverWait(getWebDriver(),4)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public List<WebElement> findAll(String xpath) {
        (new WebDriverWait(getWebDriver(),5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("("+xpath+")[1]")));
        return getWebDriver().findElements(By.xpath(xpath));
    }

    public String[] getWebelementsText(List<WebElement> webElements){
        String[] webelementsText=new String[webElements.size()];
        for(int i=1;i<webelementsText.length;i++){
            webelementsText[i]=webElements.get(i).getText();
        }
        return webelementsText;
    }

    public String[] getWebelementsParameterValue(List<WebElement> webElements, String parameterName){
        String[] webelementsParameterValue=new String[webElements.size()];
        for(int i=1;i<webelementsParameterValue.length;i++){
            webelementsParameterValue[i]=webElements.get(i).getAttribute(parameterName);
        }
        return webelementsParameterValue;
    }

    public void moveTo(WebElement webElement){
        Actions action=new Actions(getWebDriver());
        action.moveToElement(webElement).perform();
    }

    public WebElement waitVisabilityOf(WebElement webElement){
        return (new WebDriverWait(getWebDriver(),60)).until(ExpectedConditions.visibilityOf(webElement));
    }


}
