import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

import java.time.Duration;
public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";
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

    //    protected void openLoginUrl() {
    //        String url = "https://qa.koel.app/";
    //        driver.get(url);
    //    }

    protected void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.click();
        emailField.sendKeys(email);
    }
    protected void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.click();
        passwordField.sendKeys(password);
    }

    protected void clickSubmit() {
        WebElement logInButton = driver.findElement(By.cssSelector("[type='submit']"));
        logInButton.click();
    }

}