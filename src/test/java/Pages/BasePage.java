package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;
    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public List <WebElement> findListByLocator(String locator){
        return driver.findElements(By.cssSelector(locator));
    }
    public WebElement findElement(WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public void waitToClick(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public void contextClick(WebElement webElement){
        actions.contextClick(webElement).perform();
    }
    public void doubleClick(WebElement webElement){
        actions.doubleClick(webElement).perform();
    }
    public void click(WebElement webElement){
        findElement(webElement).click();
    }

}
