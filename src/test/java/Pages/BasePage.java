package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;
    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(200));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    protected WebElement findElement(WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public void contextClick(WebElement webElement){
        actions.contextClick(webElement).perform();
    }
    public void click(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
}