import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
public class BaseTest {

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = "https://qa.koel.app/";
    public static Actions actions = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    static void launchBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url =BaseURL;
        driver.get(url);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(4));
    }
    @AfterMethod
    static void closeBrowser(){
        driver.quit();
    }
    @DataProvider(name="IncorrectLoginProviders")
    public static Object [][] getDataFromDataProviders(){
        return new Object[][] {
                {"NotExistingEmail@mail.com", "NotExistingPassword"},

                {"neelam.gupta@testpro.io", " "},
                {" ", " "},

        };
    }
    protected void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    protected void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailField.clear();
        emailField.click();
        emailField.sendKeys(email);
    }
    protected void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordField.clear();
        passwordField.click();
        passwordField.sendKeys(password);
    }

    protected void clickSubmit() {
        WebElement logInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']")));
        logInButton.click();
    }

    public void doubleClickChoosePlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public WebElement hoverPlay() {
        WebElement playBtn =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='play-btn']")));
        actions.moveToElement(playBtn).perform();
        return driver.findElement(By.cssSelector("[data-testid='play-btn']"));
    }

}

